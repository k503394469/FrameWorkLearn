package com.liu.test;

import com.liu.conf.SpringConf;
import com.liu.service.UserService;
import com.liu.utils.JDBCUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConf.class})
public class JunitTest {
    @Resource
    private UserService userService;
    @Test
    public void test1() throws Exception{
        userService.save();
        ApplicationContext app=new AnnotationConfigApplicationContext(SpringConf.class);
        JDBCUtil jdbcUtil = app.getBean(JDBCUtil.class);
        System.out.println(jdbcUtil.getDataSource().getConnection());
    }
}
