package com.liu.dao;


public interface AccountDao {
    void out(int id,double money);
    void in(int id,double money);
}
