package com.knd.module.infra.controller.admin.redis.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * description = "管理后台 - 单个 Redis Key Value Response VO"
 */
@Data
@AllArgsConstructor
public class RedisKeyValueRespVO {

    /**
     * description = "c5f6990767804a928f4bb96ca249febf", requiredMode = Schema.RequiredMode.REQUIRED, example = "String"
     */
    private String key;

    /**
     * requiredMode = Schema.RequiredMode.REQUIRED, example = "String"
     */
    private String value;

}
