package com.w3.module.system.controller.admin.auth.vo;


import com.w3.framework.common.validation.InEnum;
import com.w3.framework.common.validation.Mobile;
import com.w3.module.system.enums.sms.SmsSceneEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 管理后台 - 发送手机验证码 Request VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthSmsSendReqVO {

    /**
     * 手机号 example = "18887458865"
     */
    @NotEmpty(message = "手机号不能为空")
    @Mobile
    private String mobile;

    /**
     * 短信场景 example = "1"
     */
    @NotNull(message = "发送场景不能为空")
    @InEnum(SmsSceneEnum.class)
    private Integer scene;

}
