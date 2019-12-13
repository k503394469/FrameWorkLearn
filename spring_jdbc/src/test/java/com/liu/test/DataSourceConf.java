package com.liu.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@PropertySource("druid.properties")
public class DataSourceConf {
    @Value("${driverClassName}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${username}")
//    @Value("${user}")
    private String username;
    @Value("${password}")
    private String password;

    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:1433/itheima?serverTimezone=UTC&characterEncoding=utf8");
//        dataSource.setUsername("root");
//        dataSource.setPassword("wocaibuhuiba555");
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("JTemplate")
    public JdbcTemplate getJt() {
        return new JdbcTemplate(getDataSource());
    }
}
