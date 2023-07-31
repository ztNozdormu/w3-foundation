package com.knd.module.system.single.controller.admin.permission.vo.menu;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 管理后台 - 菜单更新 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuUpdateReqVO extends MenuBaseVO {

    /**
     * description = "菜单编号",  example = "1024"
     */
    @NotNull(message = "菜单编号不能为空")
    private Long id;

}
