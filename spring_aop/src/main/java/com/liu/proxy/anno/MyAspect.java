package com.liu.proxy.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {
    @Before("cusPointCut()")
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
    @Around("execution(void com.liu.proxy.anno.*..*(..))")
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
    @After("MyAspect.cusPointCut()")
    public void after() {
        System.out.println("after");
    }
    @Pointcut("execution(void com.liu.proxy.anno.*..*(..))")
    public void cusPointCut(){}
}
