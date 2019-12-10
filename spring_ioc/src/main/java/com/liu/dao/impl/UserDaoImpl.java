package com.liu.dao.impl;

import com.liu.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("dao save!!!!!!!!");
    }
    public void init(){
        System.out.println("init!!!!!!!!");
    }
    public void destroy(){
        System.out.println("destroy!!!!!!!!");
    }
}
