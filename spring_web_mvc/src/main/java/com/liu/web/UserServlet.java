package com.liu.web;

import com.liu.service.UserService;
import com.liu.utils.WebApplicationContextUTIL;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
//@Controller("userServlet")
public class UserServlet extends BaseController {
    //    @Resource(name = "userService")
//    private UserService service;
    public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        ApplicationContext app = WebApplicationContextUTIL.getApp(context);
        UserService service = (UserService) app.getBean("userService");
        service.save();
    }

}
