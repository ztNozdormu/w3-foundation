package com.knd.module.system.controller.admin.sms.vo.channel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * description = "管理后台 - 短信渠道 Response VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SmsChannelRespVO extends SmsChannelBaseVO {

    /**
     * description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "渠道编码,参见 SmsChannelEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "YUN_PIAN"
     */
    private String code;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private LocalDateTime createTime;

}
