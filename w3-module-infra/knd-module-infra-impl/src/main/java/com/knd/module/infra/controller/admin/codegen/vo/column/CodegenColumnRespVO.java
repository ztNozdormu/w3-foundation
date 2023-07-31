package com.knd.module.infra.controller.admin.codegen.vo.column;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 管理后台 - 代码生成字段定义 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CodegenColumnRespVO extends CodegenColumnBaseVO {

    /**
     * 编号 example = "1"
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
