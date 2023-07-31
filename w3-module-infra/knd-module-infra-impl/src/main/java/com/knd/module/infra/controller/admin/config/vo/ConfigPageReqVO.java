package com.knd.module.infra.controller.admin.config.vo;

import com.knd.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * 管理后台 - 参数配置分页 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConfigPageReqVO extends PageParam {

    /**
     * 数据源名称,模糊匹配  example = "名称"
     */
    private String name;

    /**
     * 参数键名,模糊匹配 example = "yunai.db.username"
     */
    private String key;

    /**
     * 参数类型,参见 SysConfigTypeEnum 枚举   example = "1"
     */
    private Integer type;

    /**
     * 创建时间  example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
