package com.w3.module.system.controller.admin.user.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * description = "管理后台 - 用户导出 Request VO,参数和 UserPageReqVO 是一致的"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExportReqVO {

    /**
     * description = "用户账号,模糊匹配", example = "yudao"
     */
    private String username;

    /**
     * description = "手机号码,模糊匹配", example = "yudao"
     */
    private String mobile;

    /**
     * description = "展示状态,参见 CommonStatusEnum 枚举类", example = "1"
     */
    private Integer status;

    /**
     * description = "创建时间", example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    /**
     * description = "部门编号,同时筛选子部门", example = "1024"
     */
    private Long deptId;

}
