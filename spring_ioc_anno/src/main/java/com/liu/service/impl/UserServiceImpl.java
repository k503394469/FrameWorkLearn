package com.liu.service.impl;

import com.liu.dao.UserDao;
import com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//@Component("userService")
@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements UserService {
    @Value("${driverClassName}")
    private String driver;

//    @Autowired
//    @Qualifier("userDao")
    @Resource(name = "userDao")
    private UserDao userDao;

    //    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    public UserServiceImpl() {
//    }
    //如果使用@Autowired,可以省略setter
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @PostConstruct
    public void init(){
        System.out.println("init....");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroy...");
    }
    @Override
    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
        System.out.println("service save...");
        System.out.println(driver);
    }
}
