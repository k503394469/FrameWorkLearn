package com.liu.listener;

import com.liu.utils.WebApplicationContextUTIL;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@Deprecated
@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String appLocation = servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext app=new ClassPathXmlApplicationContext(appLocation);
        servletContext.setAttribute("app",app);
    }
}
