package com.knd.module.system.single.controller.admin.notify.vo.template;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 站内信模版更新 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NotifyTemplateUpdateReqVO extends NotifyTemplateBaseVO {

    /**
     * description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "ID 不能为空")
    private Long id;

}
