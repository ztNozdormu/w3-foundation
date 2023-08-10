package com.w3.framework.clickhouse.config;

import lombok.Data;
import lombok.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc ClickHouse基本配置参数
 * SQL方式执行
 */
@AutoConfiguration
@Data
public class ClickHouseConfig {

    public static String address;

    public static String username;

    public static String password;

    public static String dbName;

    public static Integer socketTimeout;

    @Value("${spring.oneself-custom.clickhouse.address}")
    public void setClickhouseAddress(String address) {
        ClickHouseConfig.address = address;
    }

    @Value("${spring.oneself-custom.clickhouse.username}")
    public void setClickhouseUsername(String username) {
        ClickHouseConfig.username = username;
    }

    @Value("${spring.oneself-custom.clickhouse.password}")
    public void setClickhousePassword(String password) {
        ClickHouseConfig.password = password;
    }

    @Value("${spring.oneself-custom.clickhouse.dbName}")
    public void setClickhouseDB(String dbName) {
        ClickHouseConfig.dbName = dbName;
    }

    @Value("${spring.oneself-custom.clickhouse.socketTimeout}")
    public void setClickhouseSocketTimeout(Integer socketTimeout) {
        ClickHouseConfig.socketTimeout = socketTimeout;
    }
    public static Connection getConn() {
        ClickHouseConnection conn;
        ClickHouseProperties properties = new ClickHouseProperties();
        properties.setUser(username);
        properties.setPassword(password);
        properties.setDatabase(dbName);
        properties.setSocketTimeout(socketTimeout);
        ClickHouseDataSource clickHouseDataSource = new ClickHouseDataSource(address, properties);
        try {
            conn = clickHouseDataSource.getConnection();
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static  List<Map<String, String>> exeSql(String sql) {
        System.out.println("cliockhouse 执行sql：" + sql);
        Connection connection = getConn();
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            ResultSetMetaData rsmd = results.getMetaData();
            List<Map<String, String>> list = new ArrayList<>();
            while (results.next()) {
                Map<String, String> row = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.put(rsmd.getColumnName(i), results.getString(rsmd.getColumnName(i)));
                }
                list.add(row);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
