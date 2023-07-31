package com.w3.module.system.controller.admin.tenant.vo.packages;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * description = "管理后台 - 租户套餐 Response VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantPackageRespVO extends TenantPackageBaseVO {

    /**
     * description = "套餐编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "创建时间"
     */
    private LocalDateTime createTime;

}
