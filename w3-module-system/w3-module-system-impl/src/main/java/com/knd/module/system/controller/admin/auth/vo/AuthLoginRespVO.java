package com.w3.module.system.controller.admin.auth.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 管理后台 - 登录 Response VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginRespVO {

    /**
     * 用户编号 example = "1024"
     */
    private Long userId;

    /**
     * 访问令牌  example = "happy"
     */
    private String accessToken;

    /**
     * 刷新令牌 example = "nice"
     */
    private String refreshToken;

    /**
     * 过期时间 example = "1024"
     */
    private LocalDateTime expiresTime;

}
