package com.liu.controller;

import com.liu.domain.User;
import com.liu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/user_list")
    public String findAll(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "user-list";
    }
}
