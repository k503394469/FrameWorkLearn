package com.liu.proxy.jdk;
//��ǿTarget����
public class Advice {
    public void before(){
        System.out.println("ǰֵ��ǿ");
    }
    public void after(){
        System.out.println("������ǿ");
    }
}
