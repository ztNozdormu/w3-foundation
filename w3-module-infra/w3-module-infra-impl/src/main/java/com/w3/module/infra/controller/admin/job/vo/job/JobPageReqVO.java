package com.w3.module.infra.controller.admin.job.vo.job;

import com.w3.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * description = "管理后台 - 定时任务分页 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JobPageReqVO extends PageParam {

    /**
     * description = "任务名称,模糊匹配", example = "测试任务"
     */
    private String name;

    /**
     * description = "任务状态,参见 JobStatusEnum 枚举", example = "1"
     */
    private Integer status;

    /**
     * description = "处理器的名字,模糊匹配", example = "sysUserSessionTimeoutJob"
     */
    private String handlerName;

}
