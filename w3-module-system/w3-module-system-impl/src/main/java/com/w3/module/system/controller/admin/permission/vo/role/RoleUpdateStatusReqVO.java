package com.w3.module.system.controller.admin.permission.vo.role;

import com.w3.framework.common.enums.CommonStatusEnum;
import com.w3.framework.common.validation.InEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 管理后台 - 角色更新状态 Request VO
 */
@Data
public class RoleUpdateStatusReqVO {

    /**
     * description = "角色编号",  example = "1024"
     */
    @NotNull(message = "角色编号不能为空")
    private Long id;

    /**
     * description = "状态,见 CommonStatusEnum 枚举", example = "1"
     */
    @NotNull(message = "状态不能为空")
    @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}")
    private Integer status;

}
