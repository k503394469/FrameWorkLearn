package com.liu.service.impl;

import com.liu.dao.RoleDao;
import com.liu.domain.Role;
import com.liu.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource(name = "roleDao")
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }
}
