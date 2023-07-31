package com.w3.module.infra.controller.admin.job.vo.job;

import lombok.Data;

/**
 * description = "管理后台 - 定时任务 Excel 导出 Request VO-参数和 JobPageReqVO 是一致的"
 */
@Data
public class JobExportReqVO {

    /**
     * description = "任务名称-模糊匹配", example = "测试任务"
     */
    private String name;

    /**
     * description = "任务状态-参见 JobStatusEnum 枚举", example = "1"
     */
    private Integer status;

    /**
     * description = "处理器的名字-模糊匹配", example = "UserSessionTimeoutJob"
     */
    private String handlerName;

}
