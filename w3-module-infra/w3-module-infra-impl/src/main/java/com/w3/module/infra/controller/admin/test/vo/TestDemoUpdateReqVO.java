package com.w3.module.infra.controller.admin.test.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 管理后台 - 字典类型更新 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TestDemoUpdateReqVO extends TestDemoBaseVO {

    /**
     * 编号
     */
    @NotNull(message = "编号不能为空")
    private Long id;

}
