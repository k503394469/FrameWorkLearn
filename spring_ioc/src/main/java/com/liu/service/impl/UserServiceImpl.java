package com.liu.service.impl;

import com.liu.dao.UserDao;
import com.liu.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
    UserDao userDao = (UserDao) app.getBean("userDao");
    @Override
    public void save() {
        userDao.save();
        System.out.println("service save...");
    }
}
