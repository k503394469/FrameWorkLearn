package com.liu.proxy.cglib;

import com.liu.proxy.cglib.impl.Target;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//基于cglib
public class ProxyDemo {
    public static void main(String[] args) {
        //目标对象
        Target target=new Target();
        //增强目标对象
        Advice advice=new Advice();
        //1,创建增强器,cglib提供
        Enhancer enhancer=new Enhancer();
        //2,给增强器设置父类(目标对象)
        enhancer.setSuperclass(Target.class);
        //3,设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy_class, Method method, Object[] parameters, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object o = methodProxy.invokeSuper(proxy_class, parameters);
                advice.after();
                return o;
            }
        });
        //4,创建代理对象
        Target proxy_target = (Target) enhancer.create();
        proxy_target.save();
    }
}
