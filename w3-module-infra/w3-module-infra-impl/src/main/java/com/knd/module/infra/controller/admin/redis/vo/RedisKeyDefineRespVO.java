package com.w3.module.infra.controller.admin.redis.vo;

import com.w3.framework.redis.core.RedisKeyDefine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;

/**
 * description = "管理后台 - Redis Key 信息 Response VO"
 */
@Data
@Builder
@AllArgsConstructor
public class RedisKeyDefineRespVO {

    /**
     * description = "Key 模板", requiredMode = Schema.RequiredMode.REQUIRED, example = "login_user:%s"
     */
    private String keyTemplate;

    /**
     * description = "Key 类型的枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "String"
     */
    private RedisKeyDefine.KeyTypeEnum keyType;

    /**
     * description = "Value 类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "java.lang.String"
     */
    private Class<?> valueType;

    /**
     * description = "超时类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    private RedisKeyDefine.TimeoutTypeEnum timeoutType;

    /**
     * description = "过期时间，单位：毫秒", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Duration timeout;

    /**
     * description = "备注", requiredMode = Schema.RequiredMode.REQUIRED, example = "啦啦啦啦~"
     */
    private String memo;

}
