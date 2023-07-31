package com.w3.module.infra.controller.admin.config.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 管理后台 - 参数配置创建 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConfigUpdateReqVO extends ConfigBaseVO {

    /**
     * 参数配置序号 example = "1024"
     */
    @NotNull(message = "参数配置编号不能为空")
    private Long id;

}
