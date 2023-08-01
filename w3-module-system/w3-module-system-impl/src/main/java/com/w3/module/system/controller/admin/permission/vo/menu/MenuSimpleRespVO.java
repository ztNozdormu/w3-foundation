package com.w3.module.system.controller.admin.permission.vo.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理后台 - 菜单精简信息 Response VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuSimpleRespVO {

    /**
     * description = "菜单编号",  example = "1024"
     */
    private Long id;

    /**
     * description = "菜单名称",  example = "芋道"
     */
    private String name;

    /**
     * description = "父菜单 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long parentId;

    /**
     * description = "类型,参见 MenuTypeEnum 枚举类",  example = "1"
     */
    private Integer type;

}
