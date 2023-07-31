package com.knd.module.system.controller.admin.permission.vo.permission;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Set;

/**
 * description = "管理后台 - 赋予角色菜单 Request VO"
 */
@Data
public class PermissionAssignRoleMenuReqVO {

    /**
     * description = "角色编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    @NotNull(message = "角色编号不能为空")
    private Long roleId;

    /**
     * description = "菜单编号列表", example = "1,3,5"
     */
    private Set<Long> menuIds = Collections.emptySet(); // 兜底

}
