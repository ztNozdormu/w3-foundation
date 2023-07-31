package com.knd.module.infra.controller.admin.db.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 管理后台 - 数据源配置更新 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DataSourceConfigUpdateReqVO extends DataSourceConfigBaseVO {

    /**
     * 主键编号 example = "1024"
     */
    @NotNull(message = "主键编号不能为空")
    private Long id;

    /**
     * 密码 example = "123456"
     */
    @NotNull(message = "密码不能为空")
    private String password;

}
