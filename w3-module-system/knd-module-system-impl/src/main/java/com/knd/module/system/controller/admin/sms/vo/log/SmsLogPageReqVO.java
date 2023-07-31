package com.knd.module.system.controller.admin.sms.vo.log;

import com.knd.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * description = "管理后台 - 短信日志分页 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SmsLogPageReqVO extends PageParam {

    /**
     * description = "短信渠道编号", example = "10"
     */
    private Long channelId;

    /**
     * description = "模板编号", example = "20"
     */
    private Long templateId;

    /**
     * description = "手机号", example = "15601691300"
     */
    private String mobile;

    /**
     * description = "发送状态,参见 SmsSendStatusEnum 枚举类", example = "1"
     */
    private Integer sendStatus;

    /**
     * description = "发送时间"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] sendTime;

    /**
     * description = "接收状态,参见 SmsReceiveStatusEnum 枚举类", example = "0"
     */
    private Integer receiveStatus;
    /**
     * description = "接收时间"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] receiveTime;

}
