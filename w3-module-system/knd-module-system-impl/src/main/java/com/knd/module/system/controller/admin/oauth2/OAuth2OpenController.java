package com.knd.module.system.controller.admin.oauth2;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.knd.framework.common.enums.UserTypeEnum;
import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.util.http.HttpUtils;
import com.knd.framework.common.util.json.JsonUtils;
import com.knd.framework.operatelog.core.annotations.OperateLog;
import com.knd.module.system.controller.admin.oauth2.vo.open.OAuth2OpenAccessTokenRespVO;
import com.knd.module.system.controller.admin.oauth2.vo.open.OAuth2OpenAuthorizeInfoRespVO;
import com.knd.module.system.controller.admin.oauth2.vo.open.OAuth2OpenCheckTokenRespVO;
import com.knd.module.system.convert.oauth2.OAuth2OpenConvert;
import com.knd.module.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import com.knd.module.system.dal.dataobject.oauth2.OAuth2ApproveDO;
import com.knd.module.system.dal.dataobject.oauth2.OAuth2ClientDO;
import com.knd.module.system.enums.oauth2.OAuth2GrantTypeEnum;
import com.knd.module.system.service.oauth2.OAuth2ApproveService;
import com.knd.module.system.service.oauth2.OAuth2ClientService;
import com.knd.module.system.service.oauth2.OAuth2GrantService;
import com.knd.module.system.service.oauth2.OAuth2TokenService;
import com.knd.module.system.util.oauth2.OAuth2Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.knd.framework.common.exception.enums.GlobalErrorCodeConstants.BAD_REQUEST;
import static com.knd.framework.common.exception.util.ServiceExceptionUtil.exception0;
import static com.knd.framework.common.pojo.CommonResult.success;
import static com.knd.framework.common.util.collection.CollectionUtils.convertList;
import static com.knd.framework.web.core.util.WebFrameworkUtils.getLoginUserId;


/**
 * 管理后台 - OAuth2.0 授权
 * <p>
 * 提供给外部应用调用为主
 * <p>
 * 一般来说，管理后台的 /system-api/* 是不直接提供给外部应用使用，主要是外部应用能够访问的数据与接口是有限的，而管理后台的 RBAC 无法很好的控制。
 * 参考大量的开放平台，都是独立的一套 OpenAPI，对应到【本系统】就是在 Controller 下新建 open 包，实现 /open-api/* 接口，然后通过 scope 进行控制。
 * 另外，一个公司如果有多个管理后台，它们 client_id 产生的 access token 相互之间是无法互通的，即无法访问它们系统的 API 接口，直到两个 client_id 产生信任授权。
 * <p>
 * 考虑到【本系统】暂时不想做的过于复杂，默认只有获取到 access token 之后，可以访问【本系统】管理后台的 /system-api/* 所有接口，除非手动添加 scope 控制。
 * scope 的使用示例，可见 {@link OAuth2UserController} 类
 *
 * @author 芋道源码
 */
@RestController
@RequestMapping("/system/oauth2")
@Validated
@Slf4j
public class OAuth2OpenController {

    @Resource
    private OAuth2GrantService oauth2GrantService;
    @Resource
    private OAuth2ClientService oauth2ClientService;
    @Resource
    private OAuth2ApproveService oauth2ApproveService;
    @Resource
    private OAuth2TokenService oauth2TokenService;


    /**
     * 获得访问令牌 description = "适合 code 授权码模式，或者 implicit 简化模式；在 sso.vue 单点登录界面被【获取】调用"
     * <p>
     * 对应 Spring Security OAuth 的 TokenEndpoint 类的 postAccessToken 方法
     * 授权码 authorization_code 模式时：code + redirectUri + state 参数
     * 密码 password 模式时：username + password + scope 参数
     * 刷新 refresh_token 模式时：refreshToken 参数
     * 客户端 client_credentials 模式：scope 参数
     * 简化 implicit 模式时：不支持
     * 注意，默认需要传递 client_id + client_secret 参数
     *
     * @param request
     * @param grantType    required = true, description = "授权类型", example = "code"
     * @param code         description = "授权范围", example = "userinfo.read"
     * @param redirectUri  description = "重定向 URI", example = "https://www.iocoder.cn"
     * @param state        description = "状态", example = "1"
     * @param username     example = "tudou"
     * @param password     example = "cai"
     * @param scope        example = "user_info"
     * @param refreshToken example = "123424233"
     * @return
     */
    @PostMapping("/token")
    @PermitAll
    @OperateLog(enable = false) // 避免 Post 请求被记录操作日志
    public CommonResult<OAuth2OpenAccessTokenRespVO> postAccessToken(HttpServletRequest request,
                                                                     @RequestParam("grant_type") String grantType,
                                                                     @RequestParam(value = "code", required = false) String code, // 授权码模式
                                                                     @RequestParam(value = "redirect_uri", required = false) String redirectUri, // 授权码模式
                                                                     @RequestParam(value = "state", required = false) String state, // 授权码模式
                                                                     @RequestParam(value = "username", required = false) String username, // 密码模式
                                                                     @RequestParam(value = "password", required = false) String password, // 密码模式
                                                                     @RequestParam(value = "scope", required = false) String scope, // 密码模式
                                                                     @RequestParam(value = "refresh_token", required = false) String refreshToken) { // 刷新模式
        List<String> scopes = OAuth2Utils.buildScopes(scope);
        // 1.1 校验授权类型
        OAuth2GrantTypeEnum grantTypeEnum = OAuth2GrantTypeEnum.getByGranType(grantType);
        if (grantTypeEnum == null) {
            throw exception0(BAD_REQUEST.getCode(), StrUtil.format("未知授权类型({})", grantType));
        }
        if (grantTypeEnum == OAuth2GrantTypeEnum.IMPLICIT) {
            throw exception0(BAD_REQUEST.getCode(), "Token 接口不支持 implicit 授权模式");
        }

        // 1.2 校验客户端
        String[] clientIdAndSecret = obtainBasicAuthorization(request);
        OAuth2ClientDO client = oauth2ClientService.validOAuthClientFromCache(clientIdAndSecret[0], clientIdAndSecret[1],
                grantType, scopes, redirectUri);

        // 2. 根据授权模式，获取访问令牌
        OAuth2AccessTokenDO accessTokenDO;
        switch (grantTypeEnum) {
            case AUTHORIZATION_CODE:
                accessTokenDO = oauth2GrantService.grantAuthorizationCodeForAccessToken(client.getClientId(), code, redirectUri, state);
                break;
            case PASSWORD:
                accessTokenDO = oauth2GrantService.grantPassword(username, password, client.getClientId(), scopes);
                break;
            case CLIENT_CREDENTIALS:
                accessTokenDO = oauth2GrantService.grantClientCredentials(client.getClientId(), scopes);
                break;
            case REFRESH_TOKEN:
                accessTokenDO = oauth2GrantService.grantRefreshToken(refreshToken, client.getClientId());
                break;
            default:
                throw new IllegalArgumentException("未知授权类型：" + grantType);
        }
        Assert.notNull(accessTokenDO, "访问令牌不能为空"); // 防御性检查
        return success(OAuth2OpenConvert.INSTANCE.convert(accessTokenDO));
    }

    /**
     * 删除访问令牌
     *
     * @param request
     * @param token   required = true, description = "访问令牌", example = "biu"
     * @return
     */
    @DeleteMapping("/token")
    @PermitAll
    @OperateLog(enable = false) // 避免 Post 请求被记录操作日志
    public CommonResult<Boolean> revokeToken(HttpServletRequest request,
                                             @RequestParam("token") String token) {
        // 校验客户端
        String[] clientIdAndSecret = obtainBasicAuthorization(request);
        OAuth2ClientDO client = oauth2ClientService.validOAuthClientFromCache(clientIdAndSecret[0], clientIdAndSecret[1],
                null, null, null);

        // 删除访问令牌
        return success(oauth2GrantService.revokeToken(client.getClientId(), token));
    }

    /**
     * 校验访问令牌
     * <p>
     * 对应 Spring Security OAuth 的 CheckTokenEndpoint 类的 checkToken 方法
     * <p>
     *
     * @param request
     * @param token   required = true, description = "访问令牌", example = "biu"
     * @return
     */
    @PostMapping("/check-token")
    @PermitAll
    @OperateLog(enable = false) // 避免 Post 请求被记录操作日志
    public CommonResult<OAuth2OpenCheckTokenRespVO> checkToken(HttpServletRequest request,
                                                               @RequestParam("token") String token) {
        // 校验客户端
        String[] clientIdAndSecret = obtainBasicAuthorization(request);
        oauth2ClientService.validOAuthClientFromCache(clientIdAndSecret[0], clientIdAndSecret[1],
                null, null, null);

        // 校验令牌
        OAuth2AccessTokenDO accessTokenDO = oauth2TokenService.checkAccessToken(token);
        Assert.notNull(accessTokenDO, "访问令牌不能为空"); // 防御性检查
        return success(OAuth2OpenConvert.INSTANCE.convert2(accessTokenDO));
    }

    /**
     * 获得授权信息  description = "适合 code 授权码模式，或者 implicit 简化模式；在 sso.vue 单点登录界面被【获取】调用"
     * <p>
     * 对应 Spring Security OAuth 的 AuthorizationEndpoint 类的 authorize 方法
     * <p>
     *
     * @param clientId required = true, description = "客户端编号", example = "tudou"
     * @return
     */
    @GetMapping("/authorize")
    public CommonResult<OAuth2OpenAuthorizeInfoRespVO> authorize(@RequestParam("clientId") String clientId) {
        // 0. 校验用户已经登录。通过 Spring Security 实现

        // 1. 获得 Client 客户端的信息
        OAuth2ClientDO client = oauth2ClientService.validOAuthClientFromCache(clientId);
        // 2. 获得用户已经授权的信息
        List<OAuth2ApproveDO> approves = oauth2ApproveService.getApproveList(getLoginUserId(), getUserType(), clientId);
        // 拼接返回
        return success(OAuth2OpenConvert.INSTANCE.convert(client, approves));
    }


    /**
     * "申请授权"  description = "适合 code 授权码模式，或者 implicit 简化模式；在 sso.vue 单点登录界面被【提交】调用"
     * <p>
     * 对应 Spring Security OAuth 的 AuthorizationEndpoint 类的 approveOrDeny 方法
     * <p>
     * 场景一：【自动授权 autoApprove = true】
     * 刚进入 sso.vue 界面，调用该接口，用户历史已经给该应用做过对应的授权，或者 OAuth2Client 支持该 scope 的自动授权
     * 场景二：【手动授权 autoApprove = false】
     * 在 sso.vue 界面，用户选择好 scope 授权范围，调用该接口，进行授权。此时，approved 为 true 或者 false
     * <p>
     * 因为前后端分离，Axios 无法很好的处理 302 重定向，所以和 Spring Security OAuth 略有不同，返回结果是重定向的 URL，剩余交给前端处理
     * <p>
     *
     * @param responseType required = true, description = "响应类型", example = "code"
     * @param clientId     required = true, description = "客户端编号", example = "tudou"
     * @param scope        description = "授权范围", example = "userinfo.read"
     * @param redirectUri  required = true, description = "重定向 URI", example = "https://www.iocoder.cn"
     * @param autoApprove  required = true, description = "用户是否接受", example = "true"
     * @param state        example = "1"
     * @return
     */
    @PostMapping("/authorize")
    @OperateLog(enable = false) // 避免 Post 请求被记录操作日志
    public CommonResult<String> approveOrDeny(@RequestParam("response_type") String responseType,
                                              @RequestParam("client_id") String clientId,
                                              @RequestParam(value = "scope", required = false) String scope,
                                              @RequestParam("redirect_uri") String redirectUri,
                                              @RequestParam(value = "auto_approve") Boolean autoApprove,
                                              @RequestParam(value = "state", required = false) String state) {
        @SuppressWarnings("unchecked")
        Map<String, Boolean> scopes = JsonUtils.parseObject(scope, Map.class);
        scopes = ObjectUtil.defaultIfNull(scopes, Collections.emptyMap());
        // 0. 校验用户已经登录。通过 Spring Security 实现

        // 1.1 校验 responseType 是否满足 code 或者 token 值
        OAuth2GrantTypeEnum grantTypeEnum = getGrantTypeEnum(responseType);
        // 1.2 校验 redirectUri 重定向域名是否合法 + 校验 scope 是否在 Client 授权范围内
        OAuth2ClientDO client = oauth2ClientService.validOAuthClientFromCache(clientId, null,
                grantTypeEnum.getGrantType(), scopes.keySet(), redirectUri);

        // 2.1 假设 approved 为 null，说明是场景一
        if (Boolean.TRUE.equals(autoApprove)) {
            // 如果无法自动授权通过，则返回空 url，前端不进行跳转
            if (!oauth2ApproveService.checkForPreApproval(getLoginUserId(), getUserType(), clientId, scopes.keySet())) {
                return success(null);
            }
        } else { // 2.2 假设 approved 非 null，说明是场景二
            // 如果计算后不通过，则跳转一个错误链接
            if (!oauth2ApproveService.updateAfterApproval(getLoginUserId(), getUserType(), clientId, scopes)) {
                return success(OAuth2Utils.buildUnsuccessfulRedirect(redirectUri, responseType, state,
                        "access_denied", "User denied access"));
            }
        }

        // 3.1 如果是 code 授权码模式，则发放 code 授权码，并重定向
        List<String> approveScopes = convertList(scopes.entrySet(), Map.Entry::getKey, Map.Entry::getValue);
        if (grantTypeEnum == OAuth2GrantTypeEnum.AUTHORIZATION_CODE) {
            return success(getAuthorizationCodeRedirect(getLoginUserId(), client, approveScopes, redirectUri, state));
        }
        // 3.2 如果是 token 则是 implicit 简化模式，则发送 accessToken 访问令牌，并重定向
        return success(getImplicitGrantRedirect(getLoginUserId(), client, approveScopes, redirectUri, state));
    }

    private static OAuth2GrantTypeEnum getGrantTypeEnum(String responseType) {
        if (StrUtil.equals(responseType, "code")) {
            return OAuth2GrantTypeEnum.AUTHORIZATION_CODE;
        }
        if (StrUtil.equalsAny(responseType, "token")) {
            return OAuth2GrantTypeEnum.IMPLICIT;
        }
        throw exception0(BAD_REQUEST.getCode(), "response_type 参数值只允许 code 和 token");
    }

    private String getImplicitGrantRedirect(Long userId, OAuth2ClientDO client,
                                            List<String> scopes, String redirectUri, String state) {
        // 1. 创建 access token 访问令牌
        OAuth2AccessTokenDO accessTokenDO = oauth2GrantService.grantImplicit(userId, getUserType(), client.getClientId(), scopes);
        Assert.notNull(accessTokenDO, "访问令牌不能为空"); // 防御性检查
        // 2. 拼接重定向的 URL
        // noinspection unchecked
        return OAuth2Utils.buildImplicitRedirectUri(redirectUri, accessTokenDO.getAccessToken(), state, accessTokenDO.getExpiresTime(),
                scopes, JsonUtils.parseObject(client.getAdditionalInformation(), Map.class));
    }

    private String getAuthorizationCodeRedirect(Long userId, OAuth2ClientDO client,
                                                List<String> scopes, String redirectUri, String state) {
        // 1. 创建 code 授权码
        String authorizationCode = oauth2GrantService.grantAuthorizationCodeForCode(userId, getUserType(), client.getClientId(), scopes,
                redirectUri, state);
        // 2. 拼接重定向的 URL
        return OAuth2Utils.buildAuthorizationCodeRedirectUri(redirectUri, authorizationCode, state);
    }

    private Integer getUserType() {
        return UserTypeEnum.ADMIN.getValue();
    }

    private String[] obtainBasicAuthorization(HttpServletRequest request) {
        String[] clientIdAndSecret = HttpUtils.obtainBasicAuthorization(request);
        if (ArrayUtil.isEmpty(clientIdAndSecret) || clientIdAndSecret.length != 2) {
            throw exception0(BAD_REQUEST.getCode(), "client_id 或 client_secret 未正确传递");
        }
        return clientIdAndSecret;
    }

}
