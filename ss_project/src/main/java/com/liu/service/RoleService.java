package com.liu.service;

import com.liu.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);
}
