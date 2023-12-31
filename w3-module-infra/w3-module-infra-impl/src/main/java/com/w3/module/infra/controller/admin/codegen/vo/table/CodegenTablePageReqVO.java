package com.w3.module.infra.controller.admin.codegen.vo.table;

import com.w3.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - 表定义分页 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CodegenTablePageReqVO extends PageParam {

    /**
     * 表名称,模糊匹配  example = "yudao"
     */
    private String tableName;

    /**
     * 表描述,模糊匹配  example = "芋道"
     */
    private String tableComment;

    /**
     * 实体,模糊匹配  Yudao
     */
    private String className;

    /**
     * 创建时间  example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
