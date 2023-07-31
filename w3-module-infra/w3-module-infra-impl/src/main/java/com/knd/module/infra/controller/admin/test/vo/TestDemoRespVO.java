package com.w3.module.infra.controller.admin.test.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 管理后台 - 字典类型 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TestDemoRespVO extends TestDemoBaseVO {

    /**
     * 编号
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
