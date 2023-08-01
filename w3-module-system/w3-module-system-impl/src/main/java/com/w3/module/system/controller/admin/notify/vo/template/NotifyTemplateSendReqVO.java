package com.w3.module.system.controller.admin.notify.vo.template;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * description = "管理后台 - 站内信模板的发送 Request VO"
 */
@Data
public class NotifyTemplateSendReqVO {

    /**
     * description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED, example = "01"
     */
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     * description = "模板编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "01"
     */
    @NotEmpty(message = "模板编码不能为空")
    private String templateCode;

    /**
     * description = "模板参数"
     */
    private Map<String, Object> templateParams;
}
