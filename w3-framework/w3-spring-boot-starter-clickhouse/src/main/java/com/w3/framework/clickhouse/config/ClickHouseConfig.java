//package com.w3.framework.clickhouse.config;
//
//import lombok.Data;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import ru.yandex.clickhouse.ClickHouseDataSource;
//import ru.yandex.clickhouse.settings.ClickHouseProperties;
//
//
///**
// * @desc ClickHouse基本配置参数
// * SQL方式执行
// */
//@AutoConfiguration
//@EnableConfigurationProperties({CkProperties.class})
//@Data
//public class ClickHouseConfig {
//
////    private static ClickHouseDataSource clickHouseDataSource;
//
//    @Bean
//    public ClickHouseDataSource clickHouseDataSource(CkProperties ckProperties) {
//        ClickHouseProperties properties = new ClickHouseProperties();
//        properties.setUser(ckProperties.username);
//        properties.setPassword(ckProperties.getPassword());
//        properties.setDatabase(ckProperties.dbName);
//        properties.setSocketTimeout(ckProperties.socketTimeout);
////        clickHouseDataSource = new ClickHouseDataSource(clickhouseProperties.address, properties);
////        return clickHouseDataSource;
//        return new ClickHouseDataSource(ckProperties.address, properties);
//    }
//
////    public static List<Map<String, String>> exeSql(String sql) {
////        System.out.println("cliockhouse 执行sql：" + sql);
////        Connection connection = null;
////        try {
////            connection = clickHouseDataSource.getConnection();
////            assert connection != null;
////            Statement statement = connection.createStatement();
////            ResultSet results = statement.executeQuery(sql);
////            ResultSetMetaData rsmd = results.getMetaData();
////            List<Map<String, String>> list = new ArrayList<>();
////            while (results.next()) {
////                Map<String, String> row = new HashMap<>();
////                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
////                    row.put(rsmd.getColumnName(i), results.getString(rsmd.getColumnName(i)));
////                }
////                list.add(row);
////            }
////            return list;
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return null;
////    }
//}
