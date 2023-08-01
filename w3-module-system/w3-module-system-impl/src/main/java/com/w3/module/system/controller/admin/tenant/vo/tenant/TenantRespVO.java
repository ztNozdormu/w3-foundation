package com.w3.module.system.controller.admin.tenant.vo.tenant;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * description = "管理后台 - 租户 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantRespVO extends TenantBaseVO {

    /**
     * description = "租户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;
    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private LocalDateTime createTime;

}
