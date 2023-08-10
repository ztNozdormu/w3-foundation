package com.w3.framework.clickhouse.config;//package io.github.ztnozdormu.dw.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * druid配置 使用多数据源该配置不需要了
// */
//@Configuration
//public class CHDruidConfig {
//
//    @Autowired
//    private CHJdbcConfig jdbcConfig;
//    @Autowired
//    private ClickHouseConfig clickHouseConfig;
//
//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(jdbcConfig.getUrl());
//        dataSource.setDriverClassName(jdbcConfig.getDriverClassName());
//        dataSource.setInitialSize(jdbcConfig.getInitialSize());
//        dataSource.setMinIdle(jdbcConfig.getMinIdle());
//        dataSource.setMaxActive(jdbcConfig.getMaxActive());
//        dataSource.setPassword(clickHouseConfig.password);
//        dataSource.setUsername(clickHouseConfig.username);
//        dataSource.setMaxWait(jdbcConfig.getMaxWait());
//        return dataSource;
//    }
//
//}
