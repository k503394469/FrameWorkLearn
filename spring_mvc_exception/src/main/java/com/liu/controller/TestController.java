package com.liu.controller;

import com.liu.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
public class TestController {
    @Resource(name = "service")
    private TestService service;
    @RequestMapping("/test1")
    @ResponseBody
    public void test1(){
        int i=1/0;
        service.show();
    }
}
