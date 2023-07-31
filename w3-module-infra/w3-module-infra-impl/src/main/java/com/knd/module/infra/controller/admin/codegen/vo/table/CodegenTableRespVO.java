package com.w3.module.infra.controller.admin.codegen.vo.table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 管理后台 - 代码生成表定义 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CodegenTableRespVO extends CodegenTableBaseVO {

    /**
     * 编号 example = "1"
     */
    private Long id;

    /**
     * 主键编号 example = "1024"
     */
    private Integer dataSourceConfigId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
