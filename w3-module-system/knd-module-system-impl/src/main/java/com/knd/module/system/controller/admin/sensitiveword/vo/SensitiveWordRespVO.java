package com.knd.module.system.controller.admin.sensitiveword.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 管理后台 - 敏感词 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SensitiveWordRespVO extends SensitiveWordBaseVO {

    /**
     * description = "编号",  example = "1"
     */
    private Long id;

    /**
     * description = "创建时间"
     */
    private LocalDateTime createTime;

}
