package com.knd.module.infra.single.controller.admin.logger.vo.apiaccesslog;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - API 访问日志 Excel 导出 Request VO,参数和 ApiAccessLogPageReqVO 是一致的
 */
@Data
public class ApiAccessLogExportReqVO {

    /**
     * 用户编号 example = "666"
     */
    private Long userId;

    /**
     * 用户类型 example = "2"
     */
    private Integer userType;

    /**
     * 应用名 example = "dashboard"
     */
    private String applicationName;

    /**
     * 请求地址,模糊匹配 example = "/xxx/yyy"
     */
    private String requestUrl;

    /**
     * 开始请求时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] beginTime;

    /**
     * 执行时长,大于等于，单位：毫秒
     */
    private Integer duration;

    /**
     * 结果码 example = "0"
     */
    private Integer resultCode;

}
