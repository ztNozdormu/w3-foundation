package com.w3.module.system.controller.admin.logger.vo.operatelog;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 *  管理后台 - 操作日志分页列表 Request VO
 */
@Data
public class OperateLogExportReqVO {

    /**
     *  description = "操作模块,模拟匹配", example = "订单"
     */
    private String module;

    /**
     * description = "用户昵称,模拟匹配", example = "芋道"
     */
    private String userNickname;

    /**
     * description = "操作分类,参见 OperateLogTypeEnum 枚举类", example = "1"
     */
    private Integer type;

    /**
     * description = "操作状态", example = "true"
     */
    private Boolean success;

    /**
     * description = "开始时间", example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startTime;

}
