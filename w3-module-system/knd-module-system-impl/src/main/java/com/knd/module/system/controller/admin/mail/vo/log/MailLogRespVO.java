package com.knd.module.system.controller.admin.mail.vo.log;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * description = "管理后台 - 邮件日志 Response VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailLogRespVO extends MailLogBaseVO {

    /**
     * description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "31020"
     */
    private Long id;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private LocalDateTime createTime;

}
