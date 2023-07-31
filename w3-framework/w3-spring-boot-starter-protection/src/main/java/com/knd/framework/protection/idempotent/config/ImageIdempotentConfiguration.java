package com.w3.framework.protection.idempotent.config;


import com.w3.framework.protection.idempotent.core.aop.IdempotentAspect;
import com.w3.framework.protection.idempotent.core.keyresolver.IdempotentKeyResolver;
import com.w3.framework.protection.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import com.w3.framework.protection.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import com.w3.framework.protection.idempotent.core.redis.IdempotentRedisDAO;
import com.w3.framework.redis.config.ImageRedisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = ImageRedisAutoConfiguration.class)
public class ImageIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
