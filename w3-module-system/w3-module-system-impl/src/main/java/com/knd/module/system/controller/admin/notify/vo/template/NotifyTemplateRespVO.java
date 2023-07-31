package com.w3.module.system.controller.admin.notify.vo.template;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * description = "管理后台 - 站内信模版 Response VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NotifyTemplateRespVO extends NotifyTemplateBaseVO {

    /**
     * description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "参数数组", example = "name,code"
     */
    private List<String> params;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private Date createTime;

}
