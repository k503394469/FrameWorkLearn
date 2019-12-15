package com.liu.dao.impl;

import com.liu.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Resource(name = "jt")
    private JdbcTemplate jt;
    @Override
    public void out(int id, double money) {
        String sql="update account set balance=balance-? where id=?";
        jt.update(sql,money,id);
    }

    @Override
    public void in(int id, double money) {
        String sql="update account set balance=balance+? where id=?";
        jt.update(sql,money,id);
    }
}
