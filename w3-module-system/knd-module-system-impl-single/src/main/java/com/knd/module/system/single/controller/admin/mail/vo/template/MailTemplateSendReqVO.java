package com.knd.module.system.single.controller.admin.mail.vo.template;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * description = "管理后台 - 邮件发送 Req VO"
 */
@Data
public class MailTemplateSendReqVO {

    /**
     * description = "接收邮箱", requiredMode = Schema.RequiredMode.REQUIRED, example = "7685413@qq.com"
     */
    @NotEmpty(message = "接收邮箱不能为空")
    private String mail;

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
