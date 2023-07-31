package com.knd.module.system.single.controller.admin.tenant.vo.tenant;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 租户更新 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TenantUpdateReqVO extends TenantBaseVO {

    /**
     * description = "租户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "租户编号不能为空")
    private Long id;

}
