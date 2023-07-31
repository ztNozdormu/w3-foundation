package com.knd.module.system.controller.admin.permission.vo.role;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * description = "管理后台 - 角色分页 Request VO"
 */
@Data
public class RoleExportReqVO {

    /**
     * description = "角色名称,模糊匹配", example = "芋道"
     */
    private String name;

    /**
     * description = "角色标识,模糊匹配", example = "yudao"
     */
    private String code;

    /**
     * description = "展示状态,参见 CommonStatusEnum 枚举类", example = "1"
     */
    private Integer status;

    /**
     * description = "开始时间", example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
