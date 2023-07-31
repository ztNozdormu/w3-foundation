package com.knd.module.system.controller.admin.user.vo.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 用户更新 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserUpdateReqVO extends UserBaseVO {

    /**
     * description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "用户编号不能为空")
    private Long id;

}
