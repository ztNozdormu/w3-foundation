package com.w3.module.infra.controller.admin.config.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 管理后台 - 参数配置创建 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConfigCreateReqVO extends ConfigBaseVO {

    /**
     * 参数键名 example = "yunai.db.username"
     */
    @NotBlank(message = "参数键名长度不能为空")
    @Size(max = 100, message = "参数键名长度不能超过100个字符")
    private String key;

}
