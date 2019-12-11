package com.liu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@PropertySource("classpath:druid.properties")
public class JDBCUtil {
    @Value("${driverClassName}")
    private String className;
    @Value("${url}")
    private String url;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Bean("dataSource")
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:1433/itheima?serverTimezone=UTC&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("wocaibuhuiba555");
        return dataSource;
    }
}
