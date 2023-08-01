package com.w3.module.infra.controller.admin.codegen.vo.table;

import lombok.Data;

/**
 * 管理后台 - 数据库的表定义 Response VO
 */
@Data
public class DatabaseTableRespVO {

    /**
     * 表名称 example = "yuanma"
     */
    private String name;

    /**
     * 表描述 example = "芋道源码"
     */
    private String comment;

}
