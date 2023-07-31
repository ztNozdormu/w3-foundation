package com.knd.module.infra.controller.admin.logger.vo.apiaccesslog;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 管理后台 - API 访问日志 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApiAccessLogRespVO extends ApiAccessLogBaseVO {

    /**
     * 日志主键 example = "1024"
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
