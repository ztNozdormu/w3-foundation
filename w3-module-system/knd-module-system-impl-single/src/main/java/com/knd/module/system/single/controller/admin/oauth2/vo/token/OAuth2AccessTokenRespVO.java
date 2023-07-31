package com.knd.module.system.single.controller.admin.oauth2.vo.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * description = "管理后台 - 访问令牌 Response VO"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2AccessTokenRespVO {

    /**
     * description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "访问令牌", requiredMode = Schema.RequiredMode.REQUIRED, example = "tudou"
     */
    private String accessToken;

    /**
     * description = "刷新令牌", requiredMode = Schema.RequiredMode.REQUIRED, example = "nice"
     */
    private String refreshToken;

    /**
     * description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "666"
     */
    private Long userId;

    /**
     * description = "用户类型,参见 UserTypeEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "2"
     */
    private Integer userType;

    /**
     * description = "客户端编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2"
     */
    private String clientId;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private LocalDateTime createTime;

    /**
     * description = "过期时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private LocalDateTime expiresTime;

}
