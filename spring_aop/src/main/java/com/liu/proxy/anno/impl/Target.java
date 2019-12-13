package com.liu.proxy.anno.impl;

import com.liu.proxy.anno.TargetInterface;
import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
//        int i=3/0;
        System.out.println("target save...");
    }
}
