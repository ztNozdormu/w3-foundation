package com.w3.module.system.controller.admin.sensitiveword.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - 敏感词 Excel 导出 Request VO,参数和 SensitiveWordPageReqVO 是一致的
 */
@Data
public class SensitiveWordExportReqVO {

    /**
     * description = "敏感词", example = "敏感词"
     */
    private String name;

    /**
     * description = "标签", example = "短信,评论"
     */
    private String tag;

    /**
     * description = "状态,参见 CommonStatusEnum 枚举类", example = "1"
     */
    private Integer status;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
