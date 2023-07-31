package com.knd.module.system.single.controller.admin.sms.vo.template;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * description = "管理后台 - 短信模板 Excel 导出 Request VO,参数和 SmsTemplatePageReqVO 是一致的"
 */
@Data
public class SmsTemplateExportReqVO {

    /**
     * description = "短信签名", example = "1"
     */
    private Integer type;

    /**
     * description = "开启状态", example = "1"
     */
    private Integer status;

    /**
     * description = "模板编码,模糊匹配", example = "test_01"
     */
    private String code;

    /**
     * description = "模板内容,模糊匹配", example = "你好，{name}。你长的太{like}啦！"
     */
    private String content;

    /**
     * description = "短信 API 的模板编号,模糊匹配", example = "4383920"
     */
    private String apiTemplateId;

    /**
     * description = "短信渠道编号", example = "10"
     */
    private Long channelId;

    /**
     * description = "创建时间"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
