package com.knd.module.infra.single.controller.admin.job.vo.job;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 定时任务 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class JobBaseVO {

    /**
     * description = "任务名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "测试任务"
     */
    @NotNull(message = "任务名称不能为空")
    private String name;

    /**
     * description = "处理器的参数", example = "yudao"
     */
    private String handlerParam;

    /**
     * description = "CRON 表达式", requiredMode = Schema.RequiredMode.REQUIRED, example = "0/10 * * * * ? *"
     */
    @NotNull(message = "CRON 表达式不能为空")
    private String cronExpression;

    /**
     * description = "重试次数", requiredMode = Schema.RequiredMode.REQUIRED, example = "3"
     */
    @NotNull(message = "重试次数不能为空")
    private Integer retryCount;

    /**
     * description = "重试间隔", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000"
     */
    @NotNull(message = "重试间隔不能为空")
    private Integer retryInterval;

    /**
     * description = "监控超时时间", example = "1000"
     */
    private Integer monitorTimeout;

}
