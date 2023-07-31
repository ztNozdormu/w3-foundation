package com.w3.module.system.controller.admin.sensitiveword.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 管理后台 - 敏感词更新 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SensitiveWordUpdateReqVO extends SensitiveWordBaseVO {

    /**
     * description = "编号", example = "1"
     */
    @NotNull(message = "编号不能为空")
    private Long id;

}
