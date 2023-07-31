package com.w3.module.infra.controller.admin.config.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - 参数配置导出 Request VO
 */
@Data
public class ConfigExportReqVO {

    /**
     * 参数名称 example = "模糊匹配"
     */
    private String name;

    /**
     * 参数键名,模糊匹配  example = "yunai.db.username"
     */
    private String key;

    /**
     * 参数类型,参见 SysConfigTypeEnum 枚举  example = "1"
     */
    private Integer type;

    /**
     * 创建时间 example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
