package com.liu.dao.impl;

import com.liu.dao.UserDao;
import com.liu.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Properties;
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("dao save!!!!!!!!");
    }
}
