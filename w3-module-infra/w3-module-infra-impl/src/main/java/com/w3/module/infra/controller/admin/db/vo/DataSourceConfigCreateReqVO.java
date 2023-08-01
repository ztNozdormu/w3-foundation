package com.w3.module.infra.controller.admin.db.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 管理后台 - 数据源配置创建 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DataSourceConfigCreateReqVO extends DataSourceConfigBaseVO {

    /**
     * 密码 example = "123456"
     */
    @NotNull(message = "密码不能为空")
    private String password;

}
