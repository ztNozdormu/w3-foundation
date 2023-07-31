package com.knd.module.infra.controller.admin.job.vo.job;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * description = "管理后台 - 定时任务 Response VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JobRespVO extends JobBaseVO {

    /**
     * description = "任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "任务状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    private Integer status;

    /**
     * description = "处理器的名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "sysUserSessionTimeoutJob"
     */
    @NotNull(message = "处理器的名字不能为空")
    private String handlerName;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private LocalDateTime createTime;

}
