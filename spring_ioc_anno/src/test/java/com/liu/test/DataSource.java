package com.liu.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.JdbcUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class DataSource {
    @Test
    //手动创建c3p0
    public void test1() throws Exception{
        ResourceBundle rb=ResourceBundle.getBundle("druid");
        String driver = rb.getString("driverClassName");
        String url = rb.getString("url");
        String username = rb.getString("username");
        String password = rb.getString("password");
        ComboPooledDataSource dpds=new ComboPooledDataSource();
        dpds.setDriverClass(driver);
        dpds.setJdbcUrl(url);
        dpds.setUser(username);
        dpds.setPassword(password);
        Connection connection = dpds.getConnection();
        System.out.println(connection);
        JdbcTemplate jt=new JdbcTemplate(dpds);
        System.out.println(jt);
        List<Map<String, Object>> maps = jt.queryForList("select * from user ");
        System.out.println(maps);
    }
    @Test
    //Spring方式创建c3p0
    public void test2() throws Exception{
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
//        ComboPooledDataSource dataSource= (ComboPooledDataSource) app.getBean("dataSource");
        ComboPooledDataSource dataSource=app.getBean(ComboPooledDataSource.class);
        System.out.println(dataSource.getConnection());
    }
    @Test
    //Spring方式创建druid
    public void test3() throws Exception{
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource=app.getBean(DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
