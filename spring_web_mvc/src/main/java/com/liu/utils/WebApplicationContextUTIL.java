package com.liu.utils;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
@Deprecated
public class WebApplicationContextUTIL {
    public static ApplicationContext getApp(ServletContext context){
        return (ApplicationContext) context.getAttribute("app");
    }
}
