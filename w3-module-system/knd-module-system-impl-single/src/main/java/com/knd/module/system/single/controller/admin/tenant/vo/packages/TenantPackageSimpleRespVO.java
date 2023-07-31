package com.knd.module.system.single.controller.admin.tenant.vo.packages;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 租户套餐精简 Response VO"
 */
@Data
public class TenantPackageSimpleRespVO {

    /**
     * description = "套餐编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "套餐编号不能为空")
    private Long id;

    /**
     * description = "套餐名", requiredMode = Schema.RequiredMode.REQUIRED, example = "VIP"
     */
    @NotNull(message = "套餐名不能为空")
    private String name;

}
