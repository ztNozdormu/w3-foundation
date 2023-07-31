package com.knd.module.infra.single.controller.admin.job.vo.job;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 定时任务更新 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JobUpdateReqVO extends JobBaseVO {

    /**
     * description = "任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "任务编号不能为空")
    private Long id;

}
