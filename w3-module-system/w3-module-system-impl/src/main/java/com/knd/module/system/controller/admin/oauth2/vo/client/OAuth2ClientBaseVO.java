package com.w3.module.system.controller.admin.oauth2.vo.client;

import cn.hutool.core.util.StrUtil;
import com.w3.framework.common.util.json.JsonUtils;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * OAuth2 客户端 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class OAuth2ClientBaseVO {

    /**
     * description = "客户端编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "tudou"
     */
    @NotNull(message = "客户端编号不能为空")
    private String clientId;

    /**
     * description = "客户端密钥", requiredMode = Schema.RequiredMode.REQUIRED, example = "fan"
     */
    @NotNull(message = "客户端密钥不能为空")
    private String secret;

    /**
     * description = "应用名", requiredMode = Schema.RequiredMode.REQUIRED, example = "土豆"
     */
    @NotNull(message = "应用名不能为空")
    private String name;

    /**
     * description = "应用图标", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/xx.png"
     */
    @NotNull(message = "应用图标不能为空")
    @URL(message = "应用图标的地址不正确")
    private String logo;

    /**
     * description = "应用描述", example = "我是一个应用"
     */
    private String description;

    /**
     * description = "状态,参见 CommonStatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * description = "访问令牌的有效期", requiredMode = Schema.RequiredMode.REQUIRED, example = "8640"
     */
    @NotNull(message = "访问令牌的有效期不能为空")
    private Integer accessTokenValiditySeconds;

    /**
     * description = "刷新令牌的有效期", requiredMode = Schema.RequiredMode.REQUIRED, example = "8640000"
     */
    @NotNull(message = "刷新令牌的有效期不能为空")
    private Integer refreshTokenValiditySeconds;

    /**
     * description = "可重定向的 URI 地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn"
     */
    @NotNull(message = "可重定向的 URI 地址不能为空")
    private List<@NotEmpty(message = "重定向的 URI 不能为空")
    @URL(message = "重定向的 URI 格式不正确") String> redirectUris;

    /**
     * description = "授权类型,参见 OAuth2GrantTypeEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "password"
     */
    @NotNull(message = "授权类型不能为空")
    private List<String> authorizedGrantTypes;

    /**
     * description = "授权范围", example = "user_info"
     */
    private List<String> scopes;

    /**
     * description = "自动通过的授权范围", example = "user_info"
     */
    private List<String> autoApproveScopes;

    /**
     * description = "权限", example = "system:user:query"
     */
    private List<String> authorities;

    /**
     * description = "资源", example = "1024"
     */
    private List<String> resourceIds;

    /**
     * description = "附加信息", example = "{yunai: true}"
     */
    private String additionalInformation;

    @AssertTrue(message = "附加信息必须是 JSON 格式")
    public boolean isAdditionalInformationJson() {
        return StrUtil.isEmpty(additionalInformation) || JsonUtils.isJson(additionalInformation);
    }

}
