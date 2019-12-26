package com.liu.dao.impl;

import com.liu.dao.UserDao;
import com.liu.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Resource(name = "jt")
    private JdbcTemplate jt;
    @Override
    public List<User> findAll() {
        String sql="select * from sys_user";
        return jt.query(sql,new BeanPropertyRowMapper<>(User.class));
    }
}
