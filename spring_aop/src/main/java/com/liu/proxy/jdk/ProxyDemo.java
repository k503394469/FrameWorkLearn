package com.liu.proxy.jdk;

import com.liu.proxy.jdk.impl.Target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        //Ŀ�����
        Target target=new Target();
        //��ǿĿ�����
        Advice advice=new Advice();

        //���ض�̬���ɵĴ������
        TargetInterface proxy_target= (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), new InvocationHandler() {
            //���ô��������κη���,ʵ��ִ��invoke()
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //ǰ��
                advice.before();
                method.invoke(target,args);
                //����
                advice.after();
                //Ŀ����󷽷�û�з���ֵ,��Ϊnull
                return null;
            }
        });
        proxy_target.save();
    }
}
