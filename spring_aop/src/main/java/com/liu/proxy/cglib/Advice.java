package com.liu.proxy.cglib;
//增强Target的类
public class Advice {
    public void before(){
        System.out.println("前值增强");
    }
    public void after(){
        System.out.println("后置增强");
    }
}
