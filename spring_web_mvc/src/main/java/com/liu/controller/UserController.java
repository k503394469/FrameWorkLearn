package com.liu.controller;

import com.liu.domain.User;
import com.liu.domain.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private ModelAndView modelAndView = new ModelAndView();

    //跳转页面
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
        modelAndView.addObject("username", "liu").addObject("password", "123");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/del")
    public String del(Model model) {
        System.out.println("Controller del");

//        model.addAttribute("username","ye").addAttribute("password",new String("老婆".getBytes("GBK"),"utf-8"));
        model.addAttribute("username", "ye").addAttribute("password", "老婆");
        return "index";
    }

    @RequestMapping(value = "/batch")
    public String batch(HttpServletRequest request) throws Exception {
        System.out.println("Controller batch");
        request.setCharacterEncoding("utf-8");
        request.setAttribute("password", "老婆!!!");
        return "index";
    }

    //回传字符串
    @RequestMapping("/para1")
    public void para1(HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("<h1>回传1</h1>");
    }

    @RequestMapping("/para2")
    @ResponseBody //告知框架,该方法直接返回数据,不进行跳转
    public String para2() throws Exception {
        return "response test";
    }

    @RequestMapping("/para3")
    @ResponseBody
    public User para3() throws Exception {
        User user = new User();
        user.setName("liu");
        user.setAge(12);
        return user;//根据spring-mvc.xml配置的参数,自动转换为json
    }

    @RequestMapping("/para4")
    @ResponseBody
    //配置mvc:annotation-driven标签，自动转为json
    public List<User> para4() throws Exception {
        User user = new User();
        user.setName("liu");
        user.setAge(12);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        return userList;
    }

    //获取参数
    @RequestMapping("/para5")
    @ResponseBody
    public String para5(String username, int age) {
        String res = username + age;
        return res;
    }

    @RequestMapping("/para6")
    @ResponseBody
    //传的name名,如果和POJO内部属性名对应,则会自动封装
    public User para6(User user) {
        return user;
    }

    @RequestMapping("/para7")
    @ResponseBody
    //传的name名,如果和数组属性名对应,则会自动封装
    public int[] para7(User user, int[] data) {
        System.out.println(user);
        return data;
    }

    @RequestMapping("/para8")
    @ResponseBody
    //传的name名,要用,name="list[角标].属性名"方式,然后SpringMVC自动封装为一个VO的POJO类
    public UserVO para8(UserVO vo) {
        return vo;
    }

    @RequestMapping("/para9")
    @ResponseBody
    //通过ajax传入一个json格式的userList,需要加入@RequestBody
    public List<User> para9(@RequestBody List<User> userList) {
//        System.out.println(userList);
        return userList;
    }

    @RequestMapping(value = "/para10", produces = "text/html;charset=utf-8")
    @ResponseBody
    //如果请求参数与业务方法参数名不一致,使用@RequestParam进行显式绑定
    public String para10(@RequestParam(value = "name", required = false, defaultValue = "lisi") String username) {
        System.out.println(username);
        return username;
    }

    //localhost:8080/spring/user/para11/zhangsan
    //使用restful风格
    @RequestMapping(value = "/para11/{username}", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String para11(@PathVariable String username) {
        System.out.println(username);
        return username;
    }

    //    @RequestMapping("/test")
//    public String test(){
//        return "forward:/user/para11/王五";
//    }
    @RequestMapping(value = "/para12", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String para12(Date date) {
        System.out.println(date);
        return date.toString();
    }
    @RequestMapping(value = "/para13", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String para13(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String res=request+"\n"+response+"\n"+session;
        return res;
    }
    @RequestMapping(value = "/para14")
    @ResponseBody
    public String para14(@RequestHeader("User-Agent") String browser,@CookieValue(value = "JSESSIONID",required = false) String sessionId) {
        String res=browser+":"+sessionId;
        return res;
    }
    //uploadTest--单文件
    @RequestMapping(value = "/para15")
    @ResponseBody
    public void para15(String name,MultipartFile uploadFile)throws Exception {
        System.out.println(name);
        String filename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("I:\\uploadFiles\\"+filename));
    }
    //uploadTest--多文件
    @RequestMapping(value = "/para16")
    @ResponseBody
    public void para16(String name,MultipartFile []uploadFiles)throws Exception {
        System.out.println(name);
        String fileName=null;
        for (MultipartFile multipartFile : uploadFiles) {
            fileName=multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("I:\\uploadFiles\\"+fileName));
        }
    }
}
