package com.w3.module.system.controller.admin.logger.vo.operatelog;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * description = "管理后台 - 操作日志 Response VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OperateLogRespVO extends OperateLogBaseVO {

    /**
     * description = "日志编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿"
     */
    private String userNickname;

}
