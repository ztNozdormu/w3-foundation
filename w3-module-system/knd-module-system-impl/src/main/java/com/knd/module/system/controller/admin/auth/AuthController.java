package com.knd.module.system.controller.admin.auth;

import cn.hutool.core.util.StrUtil;
import com.knd.framework.common.enums.CommonStatusEnum;
import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.util.collection.SetUtils;
import com.knd.framework.operatelog.core.annotations.OperateLog;
import com.knd.framework.security.config.SecurityProperties;
import com.knd.module.system.controller.admin.auth.vo.*;
import com.knd.module.system.convert.auth.AuthConvert;
import com.knd.module.system.dal.dataobject.permission.MenuDO;
import com.knd.module.system.dal.dataobject.permission.RoleDO;
import com.knd.module.system.dal.dataobject.user.AdminUserDO;
import com.knd.module.system.enums.logger.LoginLogTypeEnum;
import com.knd.module.system.enums.permission.MenuTypeEnum;
import com.knd.module.system.service.auth.AdminAuthService;
import com.knd.module.system.service.permission.PermissionService;
import com.knd.module.system.service.permission.RoleService;
import com.knd.module.system.service.social.SocialUserService;
import com.knd.module.system.service.user.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

import static com.knd.framework.common.pojo.CommonResult.success;
import static com.knd.framework.security.core.util.SecurityFrameworkUtils.obtainAuthorization;
import static com.knd.framework.web.core.util.WebFrameworkUtils.getLoginUserId;
import static java.util.Collections.singleton;

/**
 * 管理后台 - 认证
 */
@RestController
@RequestMapping("/system/auth")
@Validated
@Slf4j
public class AuthController {

    @Resource
    private AdminAuthService authService;
    @Resource
    private AdminUserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private SocialUserService socialUserService;
    @Resource
    private SecurityProperties securityProperties;

    /**
     * 使用账号密码登录
     * @param reqVO
     * @return
     */
    @PostMapping("/login")
    @PermitAll
    @OperateLog(enable = false) // 避免 Post 请求被记录操作日志
    public CommonResult<AuthLoginRespVO> login(@RequestBody @Valid AuthLoginReqVO reqVO) {
        return success(authService.login(reqVO));
    }

    /**
     * 登出系统
     * @param request
     * @return
     */
    @PostMapping("/logout")
    @PermitAll
    @OperateLog(enable = false) // 避免 Post 请求被记录操作日志
    public CommonResult<Boolean> logout(HttpServletRequest request) {
        String token = obtainAuthorization(request, securityProperties.getTokenHeader());
        if (StrUtil.isNotBlank(token)) {
            authService.logout(token, LoginLogTypeEnum.LOGOUT_SELF.getType());
        }
        return success(true);
    }

    /**
     * 刷新令牌
     * @param refreshToken  description = "刷新令牌", required = true
     * @return
     */
    @PostMapping("/refresh-token")
    @PermitAll
    @OperateLog(enable = false) // 避免 Post 请求被记录操作日志
    public CommonResult<AuthLoginRespVO> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return success(authService.refreshToken(refreshToken));
    }

    /**
     * 获取登录用户的权限信息
     * @return
     */
    @GetMapping("/get-permission-info")
    public CommonResult<AuthPermissionInfoRespVO> getPermissionInfo() {
        // 获得用户信息
        AdminUserDO user = userService.getUser(getLoginUserId());
        if (user == null) {
            return null;
        }
        // 获得角色列表
        Set<Long> roleIds = permissionService.getUserRoleIdsFromCache(getLoginUserId(), singleton(CommonStatusEnum.ENABLE.getStatus()));
        List<RoleDO> roleList = roleService.getRoleListFromCache(roleIds);
        // 获得菜单列表
        List<MenuDO> menuList = permissionService.getRoleMenuListFromCache(roleIds,
                SetUtils.asSet(MenuTypeEnum.DIR.getType(), MenuTypeEnum.MENU.getType(), MenuTypeEnum.BUTTON.getType()),
                singleton(CommonStatusEnum.ENABLE.getStatus())); // 只要开启的
        // 拼接结果返回
        return success(AuthConvert.INSTANCE.convert(user, roleList, menuList));
    }

    /**
     * 获得登录用户的菜单列表
     * @return
     */
    @GetMapping("/list-menus")
    public CommonResult<List<AuthMenuRespVO>> getMenuList() {
        // 获得角色列表
        Set<Long> roleIds = permissionService.getUserRoleIdsFromCache(getLoginUserId(), singleton(CommonStatusEnum.ENABLE.getStatus()));
        // 获得用户拥有的菜单列表
        List<MenuDO> menuList = permissionService.getRoleMenuListFromCache(roleIds,
                SetUtils.asSet(MenuTypeEnum.DIR.getType(), MenuTypeEnum.MENU.getType()), // 只要目录和菜单类型
                singleton(CommonStatusEnum.ENABLE.getStatus())); // 只要开启的
        // 转换成 Tree 结构返回
        return success(AuthConvert.INSTANCE.buildMenuTree(menuList));
    }

    // ========== 短信登录相关 ==========

    /**
     * 使用短信验证码登录
     * @param reqVO
     * @return
     */
    @PostMapping("/sms-login")
    @PermitAll
    @OperateLog(enable = false) // 避免 Post 请求被记录操作日志
    public CommonResult<AuthLoginRespVO> smsLogin(@RequestBody @Valid AuthSmsLoginReqVO reqVO) {
        return success(authService.smsLogin(reqVO));
    }

    /**
     * 发送手机验证码
     * @param reqVO
     * @return
     */
    @PostMapping("/send-sms-code")
    @PermitAll
    @OperateLog(enable = false) // 避免 Post 请求被记录操作日志
    public CommonResult<Boolean> sendLoginSmsCode(@RequestBody @Valid AuthSmsSendReqVO reqVO) {
        authService.sendSmsCode(reqVO);
        return success(true);
    }

    // ========== 社交登录相关 ==========

    /**
     * 社交授权的跳转
     * @param type description = "社交类型", required = true
     * @param redirectUri description = "回调路径"
     * @return
     */
    @GetMapping("/social-auth-redirect")
    @PermitAll
    public CommonResult<String> socialLogin(@RequestParam("type") Integer type,
                                                    @RequestParam("redirectUri") String redirectUri) {
        return success(socialUserService.getAuthorizeUrl(type, redirectUri));
    }

    /**
     * 社交快捷登录，使用 code 授权码  description = "适合未登录的用户，但是社交账号已绑定用户"
     * @param reqVO
     * @return
     */
    @PostMapping("/social-login")
    @PermitAll
    @OperateLog(enable = false) // 避免 Post 请求被记录操作日志
    public CommonResult<AuthLoginRespVO> socialQuickLogin(@RequestBody @Valid AuthSocialLoginReqVO reqVO) {
        return success(authService.socialLogin(reqVO));
    }

}
