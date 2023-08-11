package com.w3.framework.clickhouse.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * jdbc基本配置参数
 */
@ConfigurationProperties(prefix = "spring.datasource.click")
@Data
public class ClickhouseProperties {

    public String address;

    public String username;

    public String password;

    public String dbName;

    public Integer socketTimeout;

    private String driverClassName;

    private String url;

    private Integer initialSize;

    private Integer maxActive;

    private Integer minIdle;

    private Integer maxWait;

}
