package com.knd.module.system.single.controller.admin.tenant.vo.tenant;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * description = "管理后台 - 租户创建 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantCreateReqVO extends TenantBaseVO {

    /**
     *    description = "用户账号", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao"
     */
    @NotBlank(message = "用户账号不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,30}$", message = "用户账号由 数字、字母 组成")
    @Size(min = 4, max = 30, message = "用户账号长度为 4-30 个字符")
    private String username;

    /**
     * description = "密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456"
     */

    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;

}
