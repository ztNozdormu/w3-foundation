package com.knd.module.infra.controller.admin.test.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - 字典类型 Excel 导出 Request VO,参数和 TestDemoPageReqVO 是一致的
 */
@Data
public class TestDemoExportReqVO {

    /**
     * 名字
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 分类
     */
    private Integer category;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
