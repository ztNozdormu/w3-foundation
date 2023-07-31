package com.knd.module.infra.single.controller.admin.job.vo.log;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * description = "管理后台 - 定时任务 Excel 导出 Request VO,参数和 JobLogPageReqVO 是一致的"
 */
@Data
public class JobLogExportReqVO {

    /**
     * description = "任务编号", example = "10"
     */
    private Long jobId;

    /**
     * description = "处理器的名字,模糊匹配"
     */
    private String handlerName;

    /**
     * description = "开始执行时间"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime beginTime;

    /**
     * description = "结束执行时间"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    /**
     * description = "任务状态,参见 JobLogStatusEnum 枚举"
     */
    private Integer status;

}
