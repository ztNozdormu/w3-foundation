package com.knd.module.infra.controller.admin.codegen.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 管理后台 - 基于数据库的表结构，创建代码生成器的表和字段定义 Request VO
 */
@Data
public class CodegenCreateListReqVO {

    /**
     * 数据源配置的编号 example = "1"
     */
    @NotNull(message = "数据源配置的编号不能为空")
    private Long dataSourceConfigId;

    /**
     * 表名数组 example = "[1, 2, 3]"
     */
    @NotNull(message = "表名数组不能为空")
    private List<String> tableNames;

}
