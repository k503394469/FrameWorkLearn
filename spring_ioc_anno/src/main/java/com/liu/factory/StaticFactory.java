package com.liu.factory;

import com.liu.dao.UserDao;
import com.liu.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
