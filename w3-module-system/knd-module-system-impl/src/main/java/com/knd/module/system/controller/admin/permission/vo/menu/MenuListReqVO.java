package com.knd.module.system.controller.admin.permission.vo.menu;

import lombok.Data;

/**
 * 管理后台 - 菜单列表 Request VO
 */
@Data
public class MenuListReqVO {

    /**
     * description = "菜单名称,模糊匹配", example = "芋道"
     */
    private String name;

    /**
     * description = "展示状态,参见 CommonStatusEnum 枚举类", example = "1"
     */
    private Integer status;

}
