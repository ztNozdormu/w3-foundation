package com.w3.module.system.controller.admin.sms.vo.template;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * description = "管理后台 - 短信模板的发送 Request VO"
 */
@Data
public class SmsTemplateSendReqVO {

    /**
     * description = "手机号", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300"
     */
    @NotNull(message = "手机号不能为空")
    private String mobile;

    /**
     * description = "模板编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "test_01"
     */
    @NotNull(message = "模板编码不能为空")
    private String templateCode;

    /**
     * description = "模板参数"
     */
    private Map<String, Object> templateParams;

}
