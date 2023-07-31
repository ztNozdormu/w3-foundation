package com.knd.module.system.single.controller.admin.mail.vo.template;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * description = "管理后台 - 邮件末班 Response VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MailTemplateRespVO extends MailTemplateBaseVO {

    /**
     * description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "参数数组", example = "name,code"
     */
    private List<String> params;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private LocalDateTime createTime;

}
