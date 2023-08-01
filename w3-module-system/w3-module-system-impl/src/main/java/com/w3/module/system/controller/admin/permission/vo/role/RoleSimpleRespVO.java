package com.w3.module.system.controller.admin.permission.vo.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理后台 - 角色精简信息 Response VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleSimpleRespVO {

    /**
     * description = "角色编号",  example = "1024"
     */
    private Long id;

    /**
     * description = "角色名称",  example = "芋道"
     */
    private String name;

}
