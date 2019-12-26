package com.liu.controller;

import com.liu.domain.Role;
import com.liu.domain.User;
import com.liu.service.RoleService;
import com.liu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "roleService")
    private RoleService roleService;
    @RequestMapping("/user_list")
    public String findAll(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "user-list";
    }
    @RequestMapping("/saveUI")
    public String saveUI(Model model){
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "user-add";
    }
    @RequestMapping("/save")
    public String save(User user,Long [] roleIds){
        userService.saveUserByUserMapAndRoleId(user,roleIds);
        return "redirect:/user/user_list";
    }
    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId){
        userService.delUser(userId);
        return "redirect:/user/user_list";
    }
}
