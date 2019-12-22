package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/target")
public class TargetController {
    @RequestMapping("/test1")
    public String test1(Model model){
        model.addAttribute("name","你好");
        return "index";
    }
}
