package com.w3.module.system.controller.admin.user.vo.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 用户更新密码 Request VO"
 */
@Data
public class UserUpdatePasswordReqVO {

    /**
     * description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "用户编号不能为空")
    private Long id;

    /**
     * description = "密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456"
     */
    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;

}
