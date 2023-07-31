package com.knd.module.infra.single.controller.admin.job.vo.job;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 定时任务创建 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JobCreateReqVO extends JobBaseVO {

    /**
     * description = "处理器的名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "sysUserSessionTimeoutJob"
     */
    @NotNull(message = "处理器的名字不能为空")
    private String handlerName;

}

