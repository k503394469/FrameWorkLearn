package com.liu.controller;

import com.liu.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class controller {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService service= (AccountService) app.getBean("accountService");
        service.transfer(1,2,300);
    }
}
