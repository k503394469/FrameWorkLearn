package com.liu.proxy.aop.impl;

import com.liu.proxy.aop.TargetInterface;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("target save...");
    }
}
