package com.w3.module.system.controller.admin.mail.vo.account;

import com.w3.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * description = "管理后台 - 邮箱账号分页 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailAccountPageReqVO extends PageParam {

    /**
     * description = "邮箱", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudaoyuanma@123.com"
     */
    private String mail;

    /**
     * description = "用户名" , requiredMode = Schema.RequiredMode.REQUIRED , example = "yudao"
     */
    private String username;

}
