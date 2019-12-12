package com.liu.proxy.jdk;

import com.liu.proxy.jdk.impl.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        //目标对象
        Target target=new Target();
        //增强目标对象
        Advice advice=new Advice();

        //返回动态生成的代理对象
        TargetInterface proxy_target= (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), new InvocationHandler() {
            //调用代理对象的任何方法,实际执行invoke()
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //前置
                advice.before();
                method.invoke(target,args);
                //后置
                advice.after();
                //目标对象方法没有返回值,则为null
                return null;
            }
        });
        proxy_target.save();
    }
}
