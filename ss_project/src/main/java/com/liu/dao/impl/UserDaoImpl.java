package com.liu.dao.impl;

import com.liu.dao.UserDao;
import com.liu.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    @Override
    public Long saveUser(User user) {
        PreparedStatementCreator creator=new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setString(2,user.getUsername());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getPassword());
                preparedStatement.setString(5,user.getPhoneNum());
                return preparedStatement;
            }
        };
        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();

        jt.update(creator,keyHolder);
        //获取生成的主键
        long userId = keyHolder.getKey().longValue();
        return userId;
    }

    @Override
    public void saveUserByUserIdAndRoleId(Long userId, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jt.update("insert into sys_user_role values (?,?)",userId,roleId);
        }
    }

    @Override
    public void delFromRelation(Long userId) {
        jt.update("delete from sys_user_role where userId=?",userId);
    }

    @Override
    public void delFromUser(Long userId) {
        jt.update("delete from sys_user where id=?",userId);
    }
}
