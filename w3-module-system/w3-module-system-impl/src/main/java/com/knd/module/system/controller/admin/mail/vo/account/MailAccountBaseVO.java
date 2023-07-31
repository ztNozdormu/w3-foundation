package com.w3.module.system.controller.admin.mail.vo.account;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * 邮箱账号 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class MailAccountBaseVO {

    /**
     * description = "邮箱", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudaoyuanma@123.com"
     */
    @NotNull(message = "邮箱不能为空")
    @Email(message = "必须是 Email 格式")
    private String mail;

    /**
     * description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao"
     */
    @NotNull(message = "用户名不能为空")
    private String username;

    /**
     * description = "密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456"
     */
    @NotNull(message = "密码必填")
    private String password;

    /**
     * description = "SMTP 服务器域名", requiredMode = Schema.RequiredMode.REQUIRED, example = "www.iocoder.cn"
     */
    @NotNull(message = "SMTP 服务器域名不能为空")
    private String host;

    /**
     * description = "SMTP 服务器端口", requiredMode = Schema.RequiredMode.REQUIRED, example = "80"
     */
    @NotNull(message = "SMTP 服务器端口不能为空")
    private Integer port;

    /**
     * description = "是否开启 ssl", requiredMode = Schema.RequiredMode.REQUIRED, example = "true"
     */
    @NotNull(message = "是否开启 ssl 必填")
    private Boolean sslEnable;

}
