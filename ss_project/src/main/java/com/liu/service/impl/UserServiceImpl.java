package com.liu.service.impl;

import com.liu.dao.RoleDao;
import com.liu.dao.UserDao;
import com.liu.domain.Role;
import com.liu.domain.User;
import com.liu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;
    @Resource(name = "roleDao")
    private RoleDao roleDao;
    @Override
    public List<User> findAll() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            List<Role> roles=roleDao.findRoleNameByUserId(user.getId());
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void saveUserByUserMapAndRoleId(User user, Long[] roleIds) {
        Long userId=userDao.saveUser(user);
        userDao.saveUserByUserIdAndRoleId(userId,roleIds);
    }

    @Override
    public void delUser(Long userId) {
        userDao.delFromRelation(userId);
        userDao.delFromUser(userId);
    }
}
