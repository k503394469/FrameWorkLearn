package com.liu.web;

import com.liu.service.UserService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseController {
        private UserService service=app.getBean(UserService.class);
//    @Resource(name = "userService")
//    private UserService service;
    public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service.save();
    }

}
