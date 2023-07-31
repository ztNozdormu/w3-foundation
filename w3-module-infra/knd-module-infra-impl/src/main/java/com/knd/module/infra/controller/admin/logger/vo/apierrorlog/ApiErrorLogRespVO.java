package com.knd.module.infra.controller.admin.logger.vo.apierrorlog;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 管理后台 - API 错误日志 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApiErrorLogRespVO extends ApiErrorLogBaseVO {

    /**
     * 编号 example = "1024"
     */
    private Integer id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 处理时间
     */
    private LocalDateTime processTime;

    /**
     * 处理用户编号
     */
    private Integer processUserId;

}
