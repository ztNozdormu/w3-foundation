package com.w3.module.infra.controller.admin.logger.vo.apierrorlog;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - API 错误日志 Excel 导出 Request VO,参数和 ApiErrorLogPageReqVO 是一致的
 */
@Data
public class ApiErrorLogExportReqVO {

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 应用名
     */
    private String applicationName;

    /**
     * 请求地址 example = "/xx/yy"
     */
    private String requestUrl;

    /**
     * 异常发生时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] exceptionTime;

    /**
     * 处理状态
     */
    private Integer processStatus;

}
