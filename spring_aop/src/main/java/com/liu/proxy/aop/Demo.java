package com.liu.proxy.aop;

import com.liu.proxy.aop.impl.Target;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        TargetInterface bean = (TargetInterface) app.getBean("target");
        bean.save();
    }
}
