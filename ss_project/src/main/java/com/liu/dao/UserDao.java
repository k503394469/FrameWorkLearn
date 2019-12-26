package com.liu.dao;

import com.liu.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    Long saveUser(User user);

    void saveUserByUserIdAndRoleId(Long userId, Long[] roleIds);

    void delFromRelation(Long userId);

    void delFromUser(Long userId);
}
