package com.w3.module.system.controller.admin.errorcode.vo;

import com.w3.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - 错误码分页 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErrorCodePageReqVO extends PageParam {

    /**
     * 错误码类型,参见 ErrorCodeTypeEnum 枚举类  example = "1"
     */
    private Integer type;

    /**
     * 应用名 example = "dashboard"
     */
    private String applicationName;

    /**
     * 错误码编码   example = "1234"
     */
    private Integer code;

    /**
     * 错误码错误提示 example = "帅气"
     */
    private String message;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
