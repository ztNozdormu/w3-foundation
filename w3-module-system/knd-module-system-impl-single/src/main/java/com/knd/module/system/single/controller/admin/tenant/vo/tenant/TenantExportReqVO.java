package com.knd.module.system.single.controller.admin.tenant.vo.tenant;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * description = "管理后台 - 租户 Excel 导出 Request VO,参数和 TenantPageReqVO 是一致的"
 */
@Data
public class TenantExportReqVO {

    /**
     * description = "租户名", example = "芋道"
     */

    private String name;

    /**
     * description = "联系人", example = "芋艿"
     */
    private String contactName;

    /**
     *  description = "联系手机", example = "15601691300"
     */
    private String contactMobile;

    /**
     *  description = "租户状态（0正常 1停用）", example = "1"
     */
    private Integer status;

    /**
     * description = "创建时间"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
