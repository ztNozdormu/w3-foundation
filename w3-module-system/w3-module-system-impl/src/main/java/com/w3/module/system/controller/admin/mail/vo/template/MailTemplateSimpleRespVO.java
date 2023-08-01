package com.w3.module.system.controller.admin.mail.vo.template;

import lombok.Data;

/**
 * description = "管理后台 - 邮件模版的精简 Response VO"
 */
@Data
public class MailTemplateSimpleRespVO {

    /**
     * description = "模版编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "模版名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "哒哒哒"
     */
    private String name;

}
