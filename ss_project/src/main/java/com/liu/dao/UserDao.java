package com.liu.dao;

import com.liu.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
