package com.w3.module.system.controller.admin.auth.vo;

import com.w3.framework.common.validation.Mobile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * 管理后台 - 短信验证码的登录 Request VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthSmsLoginReqVO {

    /**
     * 手机号 example = "yudaoyuanma"
     */
    @NotEmpty(message = "手机号不能为空")
    @Mobile
    private String mobile;

    /**
     * 短信验证码 example = "1024"
     */
    @NotEmpty(message = "验证码不能为空")
    private String code;

}
