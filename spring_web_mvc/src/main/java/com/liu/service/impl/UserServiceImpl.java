package com.liu.service.impl;

import com.liu.dao.UserDao;
import com.liu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao dao;
    @Override
    public void save() {
        dao.save();
        System.out.println("service save...");
    }
}
