package com.liu.proxy.jdk.impl;

import com.liu.proxy.jdk.TargetInterface;

public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("target save...");
    }
}
