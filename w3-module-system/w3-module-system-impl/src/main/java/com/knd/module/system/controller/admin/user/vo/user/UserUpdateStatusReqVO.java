package com.w3.module.system.controller.admin.user.vo.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 用户更新状态 Request VO"
 */
@Data
public class UserUpdateStatusReqVO {

    /**
     * description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "角色编号不能为空")
    private Long id;

    /**
     * description = "状态,见 CommonStatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    @NotNull(message = "状态不能为空")
//    @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}")
    private Integer status;

}
