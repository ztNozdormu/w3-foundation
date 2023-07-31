package com.knd.module.system.single.controller.admin.sms.vo.channel;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 短信渠道精简 Response VO"
 */
@Data
public class SmsChannelSimpleRespVO {

    /**
     * description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "编号不能为空")
    private Long id;

    /**
     * description = "短信签名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋道源码"
     */
    @NotNull(message = "短信签名不能为空")
    private String signature;

    /**
     * description = "渠道编码,参见 SmsChannelEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "YUN_PIAN"
     */
    private String code;

}
