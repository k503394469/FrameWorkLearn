package com.liu.proxy.aop.impl;

import com.liu.proxy.aop.TargetInterface;

public class Target implements TargetInterface {
    @Override
    public void save() {
//        int i=3/0;
        System.out.println("target save...");
    }
}
