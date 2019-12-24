package com.liu.dao.impl;

import com.liu.dao.TestDao;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImpl implements TestDao {
    @Override
    public String show() {
        return "...";
    }
}
