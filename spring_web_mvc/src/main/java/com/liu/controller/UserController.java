package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/save")
    public String save(){
        System.out.println("Controller save");
        return "index";
//        return "redirect:/index.jsp";
    }
}
