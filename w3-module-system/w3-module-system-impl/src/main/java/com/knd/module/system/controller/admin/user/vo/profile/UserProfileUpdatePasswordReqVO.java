package com.w3.module.system.controller.admin.user.vo.profile;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * description = "管理后台 - 用户个人中心更新密码 Request VO"
 */
@Data
public class UserProfileUpdatePasswordReqVO {

    /**
     * description = "旧密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456"
     */
    @NotEmpty(message = "旧密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String oldPassword;

    /**
     * description = "新密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "654321"
     */
    @NotEmpty(message = "新密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String newPassword;

}
