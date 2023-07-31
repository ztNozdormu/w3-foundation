package com.w3.module.system.controller.admin.errorcode.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - 错误码 Excel 导出 Request VO,参数和 InfErrorCodePageReqVO 是一致的
 */
@Data
public class ErrorCodeExportReqVO {

    /**
     * description = "错误码类型", example = "1"
     */
    private Integer type;

    /**
     * description = "应用名", example = "dashboard"
     */
    private String applicationName;

    /**
     * description = "错误码编码", example = "1234"
     */
    private Integer code;

    /**
     * description = "错误码错误提示", example = "帅气"
     */
    private String message;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
