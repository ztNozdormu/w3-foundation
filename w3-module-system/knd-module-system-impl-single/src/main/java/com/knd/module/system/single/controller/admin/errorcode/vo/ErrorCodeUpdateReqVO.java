package com.knd.module.system.single.controller.admin.errorcode.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 错误码更新 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErrorCodeUpdateReqVO extends ErrorCodeBaseVO {

    /**
     * description = "错误码编号", example = "1024"
     */
    @NotNull(message = "错误码编号不能为空")
    private Long id;

}
