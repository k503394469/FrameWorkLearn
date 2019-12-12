package com.liu.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.liu.conf.SpringConf;
import com.liu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConf.class})
public class JunitTest {
    @Resource
    private UserService userService;
    @Resource(name = "dataSource")
    private DruidDataSource dataSource;
    @Test
    public void test1() throws Exception{
        userService.save();
        JdbcTemplate jt=new JdbcTemplate(dataSource);
        System.out.println(jt.queryForList("select * from user"));
    }
}
