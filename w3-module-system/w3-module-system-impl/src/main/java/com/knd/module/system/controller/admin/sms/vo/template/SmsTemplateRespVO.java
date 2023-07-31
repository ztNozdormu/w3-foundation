package com.w3.module.system.controller.admin.sms.vo.template;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * description = "管理后台 - 短信模板 Response VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SmsTemplateRespVO extends SmsTemplateBaseVO {

    /**
     * description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "短信渠道编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "ALIYUN"
     */
    private String channelCode;

    /**
     * description = "参数数组", example = "name,code"
     */
    private List<String> params;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private LocalDateTime createTime;

}
