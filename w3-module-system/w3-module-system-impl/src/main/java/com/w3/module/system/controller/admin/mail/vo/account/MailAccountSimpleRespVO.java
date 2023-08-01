package com.w3.module.system.controller.admin.mail.vo.account;

import lombok.Data;

/**
 * description = "管理后台 - 邮箱账号的精简 Response VO"
 */
@Data
public class MailAccountSimpleRespVO {

    /**
     * description = "邮箱编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "邮箱", requiredMode = Schema.RequiredMode.REQUIRED, example = "768541388@qq.com"
     */
    private String mail;

}
