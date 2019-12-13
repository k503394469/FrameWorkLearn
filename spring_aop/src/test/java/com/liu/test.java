package com.liu;

import com.liu.proxy.anno.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-anno.xml")
public class test {
    @Resource
    private TargetInterface target;
    @Test
    public void test1(){
        target.save();
    }
}
