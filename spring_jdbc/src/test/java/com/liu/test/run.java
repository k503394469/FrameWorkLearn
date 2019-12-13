package com.liu.test;

import com.liu.SpringConf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConf.class})
public class run {
    @Resource(name = "JTemplate")
    private JdbcTemplate jt;
    @Test
    public void test1(){
        System.out.println(jt.queryForList("select * from user"));
    }
}
