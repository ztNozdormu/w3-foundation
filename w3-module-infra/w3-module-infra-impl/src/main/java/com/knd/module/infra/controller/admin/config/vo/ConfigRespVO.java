package com.w3.module.infra.controller.admin.config.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 管理后台 - 参数配置信息 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ConfigRespVO extends ConfigBaseVO {

    /**
     * 参数配置序号  example = "1024"
     */
    private Long id;

    /**
     * 参数键名 example = "yunai.db.username"
     */
    @NotBlank(message = "参数键名长度不能为空")
    @Size(max = 100, message = "参数键名长度不能超过100个字符")
    private String key;

    /**
     * 参数类型,参见 SysConfigTypeEnum 枚举 example = "1"
     */
    private Integer type;

    /**
     * 创建时间 example = "时间戳格式"
     */
    private LocalDateTime createTime;

}
