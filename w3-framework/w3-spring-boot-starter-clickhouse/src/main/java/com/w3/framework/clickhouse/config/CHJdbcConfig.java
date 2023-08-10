package com.w3.framework.clickhouse.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * jdbc基本配置参数
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource.click")
@Data
public class CHJdbcConfig {
    private String  driverClassName;
    private String  url;
    private Integer initialSize;
    private Integer maxActive;
    private Integer minIdle;
    private Integer maxWait;

}
