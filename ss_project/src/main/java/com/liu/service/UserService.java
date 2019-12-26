package com.liu.service;

import com.liu.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void saveUserByUserMapAndRoleId(User user, Long[] roleIds);

    void delUser(Long userId);
}
