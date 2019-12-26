package com.liu.dao;

import com.liu.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleNameByUserId(Long id);
}
