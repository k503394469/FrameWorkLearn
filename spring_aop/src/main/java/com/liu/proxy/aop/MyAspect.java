package com.liu.proxy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void before() {
        System.out.println("before");
    }

    public void afterReturning() {
        System.out.println("afterReturning");
    }

    /**
     * 连接点方法→切点方法(目标方法)
     * @param joinPoint
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        //target Class...run
        Object proxy_target = joinPoint.proceed();
        System.out.println("around after");
        return proxy_target;
    }
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }
    public void after() {
        System.out.println("after");
    }
}
