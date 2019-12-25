package com.liu.dao.impl;

import com.liu.dao.RoleDao;
import com.liu.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
    @Resource(name = "jt")
    private JdbcTemplate jt;
    @Override
    public List<Role> findAll() {
        String sql="select * from sys_role";
        List<Role> roleList = jt.query(sql, new BeanPropertyRowMapper<>(Role.class));
        return roleList;
    }
}
