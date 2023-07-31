package com.w3.module.infra.controller.admin.db.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 管理后台 - 数据源配置 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DataSourceConfigRespVO extends DataSourceConfigBaseVO {

    /**
     * 主键编号 example = "1024"
     */
    private Integer id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
