package com.knd.module.infra.single.controller.admin.job.vo.log;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 定时任务日志 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class JobLogBaseVO {

    /**
     * description = "任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "任务编号不能为空")
    private Long jobId;

    /**
     * description = "处理器的名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "sysUserSessionTimeoutJob"
     */
    @NotNull(message = "处理器的名字不能为空")
    private String handlerName;

    /**
     * description = "处理器的参数", example = "yudao"
     */
    private String handlerParam;

    /**
     * description = "第几次执行", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    @NotNull(message = "第几次执行不能为空")
    private Integer executeIndex;

    /**
     * description = "开始执行时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    @NotNull(message = "开始执行时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime beginTime;

    /**
     * description = "结束执行时间"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    /**
     * description = "执行时长", example = "123"
     */
    private Integer duration;

    /**
     * description = "任务状态,参见 JobLogStatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    @NotNull(message = "任务状态不能为空")
    private Integer status;

    /**
     * description = "结果数据", example = "执行成功"
     */
    private String result;

}
