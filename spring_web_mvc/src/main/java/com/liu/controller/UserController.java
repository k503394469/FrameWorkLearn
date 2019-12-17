package com.liu.controller;

import com.liu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private ModelAndView modelAndView=new ModelAndView();
    //��תҳ��
    @RequestMapping(value = "/save")
    public String save() {
        System.out.println("Controller save");
        return "index";
//        return "redirect:/jsp/index.jsp";
    }
    @RequestMapping(value = "/update")
    public ModelAndView update() {
        System.out.println("Controller update");
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/add")
    public ModelAndView add() {
        System.out.println("Controller add");
        modelAndView.addObject("username","liu").addObject("password","123");
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/del")
    public String del(Model model) {
        System.out.println("Controller del");

//        model.addAttribute("username","ye").addAttribute("password",new String("����".getBytes("GBK"),"utf-8"));
        model.addAttribute("username","ye").addAttribute("password","����");
        return "index";
    }
    @RequestMapping(value = "/batch")
    public String batch(HttpServletRequest request)throws Exception {
        System.out.println("Controller batch");
        request.setCharacterEncoding("utf-8");
        request.setAttribute("password","����!!!");
        return "index";
    }
    //�ش��ַ���
    @RequestMapping("/para1")
    public void para1(HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("<h1>�ش�1</h1>");
    }
    @RequestMapping("/para2")
    @ResponseBody //��֪���,�÷���ֱ�ӷ�������,��������ת
    public String para2() throws Exception{
        return "response test";
    }
    @RequestMapping("/para3")
    @ResponseBody
    public User para3() throws Exception{
        User user=new User();
        user.setName("liu");
        user.setAge(12);
        return user;//����spring-mvc.xml���õĲ���,�Զ�ת��Ϊjson
    }
    @RequestMapping("/para4")
    @ResponseBody
    public List<User> para4() throws Exception{
        User user=new User();
        user.setName("liu");
        user.setAge(12);
        List<User> userList=new ArrayList<>();
        userList.add(user);
        return userList;
    }
}
