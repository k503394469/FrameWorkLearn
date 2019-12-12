package com.liu.proxy.cglib;

import com.liu.proxy.cglib.impl.Target;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//����cglib
public class ProxyDemo {
    public static void main(String[] args) {
        //Ŀ�����
        Target target=new Target();
        //��ǿĿ�����
        Advice advice=new Advice();
        //1,������ǿ��,cglib�ṩ
        Enhancer enhancer=new Enhancer();
        //2,����ǿ�����ø���(Ŀ�����)
        enhancer.setSuperclass(Target.class);
        //3,���ûص�
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy_class, Method method, Object[] parameters, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object o = methodProxy.invokeSuper(proxy_class, parameters);
                advice.after();
                return o;
            }
        });
        //4,�����������
        Target proxy_target = (Target) enhancer.create();
        proxy_target.save();
    }
}
