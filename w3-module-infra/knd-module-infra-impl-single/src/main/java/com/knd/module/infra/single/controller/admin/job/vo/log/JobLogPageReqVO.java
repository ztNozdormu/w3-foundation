package com.knd.module.infra.single.controller.admin.job.vo.log;

import com.knd.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * description = "管理后台 - 定时任务日志分页 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JobLogPageReqVO extends PageParam {

    /**
     * description = "任务编号", example = "10"
     */
    private Long jobId;

    /**
     * description = "处理器的名字,模糊匹配"
     */
    private String handlerName;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    /**
     * description = "开始执行时间"
     */
    private LocalDateTime beginTime;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    /**
     * description = "结束执行时间"
     */
    private LocalDateTime endTime;

    /**
     * description = "任务状态,参见 JobLogStatusEnum 枚举"
     */
    private Integer status;

}
