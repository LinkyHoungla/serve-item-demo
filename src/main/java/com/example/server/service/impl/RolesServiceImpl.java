package com.example.server.service.impl;

import com.example.server.dao.RoleDao;
import com.example.server.model.Role;
import com.example.server.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RoleDao roleDao;


    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Integer createRole(Role role) {
        return roleDao.createRole(role);
    }

    @Override
    public Integer updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public Integer deleteRoleById(Integer roleId) {
        return roleDao.deleteRoleById(roleId);
    }
}
