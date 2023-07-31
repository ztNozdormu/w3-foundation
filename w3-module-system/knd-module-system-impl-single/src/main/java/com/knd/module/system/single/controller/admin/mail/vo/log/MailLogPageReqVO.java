package com.knd.module.system.single.controller.admin.mail.vo.log;

import com.knd.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * description = "管理后台 - 邮箱日志分页 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailLogPageReqVO extends PageParam {

    /**
     * description = "用户编号", example = "30883"
     */
    private Long userId;

    /**
     * description = "用户类型 - 参见 UserTypeEnum 枚举", example = "2"
     */
    private Integer userType;

    /**
     * description = "接收邮箱地址 模糊匹配", example = "76854@qq.com"
     */
    private String toMail;

    /**
     * description = "邮箱账号编号", example = "18107"
     */
    private Long accountId;

    /**
     * description = "模板编号", example = "5678"
     */
    private Long templateId;

    /**
     * description = "发送状态 - 参见 MailSendStatusEnum 枚举", example = "1"
     */
    private Integer sendStatus;

    /**
     * description = "发送时间"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] sendTime;

}
