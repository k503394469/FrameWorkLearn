package com.liu.dao.impl;

import com.liu.dao.UserDao;
import com.liu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Properties;
public class UserDaoImpl implements UserDao {
    private List<String> list;
    private Map<String, User> userMap;
    private Properties properties;

    private String username;
    private int age;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void save() {
        System.out.println("dao save!!!!!!!!");
        System.out.println(list);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println(username+"::::"+age);
    }
}
