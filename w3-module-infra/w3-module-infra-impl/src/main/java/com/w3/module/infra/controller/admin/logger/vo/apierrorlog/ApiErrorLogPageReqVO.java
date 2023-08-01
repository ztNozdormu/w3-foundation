package com.w3.module.infra.controller.admin.logger.vo.apierrorlog;

import com.w3.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - API 错误日志分页 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApiErrorLogPageReqVO extends PageParam {

    /**
     * 用户编号 example = "666"
     */
    private Long userId;

    /**
     * 用户类型 example = "1"
     */
    private Integer userType;

    /**
     * 应用名  example = "dashboard"
     */
    private String applicationName;

    /**
     * 请求地址  example = "/xx/yy"
     */
    private String requestUrl;

    /**
     * 异常发生时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] exceptionTime;

    /**
     * 处理状态 example = "0"
     */
    private Integer processStatus;

}
