package com.liu.controller;

import com.liu.domain.Role;
import com.liu.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource(name = "roleService")
    private RoleService roleService;
    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/show_list";
    }
    @RequestMapping("/show_list")
    public String findAll(Model model) {
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "role-list";
    }
}
