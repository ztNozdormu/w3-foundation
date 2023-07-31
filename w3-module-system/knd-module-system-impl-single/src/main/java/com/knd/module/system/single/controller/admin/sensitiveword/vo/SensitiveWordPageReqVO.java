package com.knd.module.system.single.controller.admin.sensitiveword.vo;

import com.knd.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - 敏感词分页 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SensitiveWordPageReqVO extends PageParam {

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
