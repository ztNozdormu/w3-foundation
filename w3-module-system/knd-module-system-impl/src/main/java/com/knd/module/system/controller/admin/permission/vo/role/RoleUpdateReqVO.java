package com.knd.module.system.controller.admin.permission.vo.role;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 管理后台 - 角色更新 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleUpdateReqVO extends RoleBaseVO {

    /**
     * description = "角色编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "角色编号不能为空")
    private Long id;

}
