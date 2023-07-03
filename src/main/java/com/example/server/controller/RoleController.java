package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.entity.Role;
import com.example.server.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceImpl rolesService;

    @GetMapping("/list")
    public ApiResponse<List<Role>> getRoleList(){
        return ApiResponse.success(rolesService.getRoleList());
    }

    @PostMapping
    public ApiResponse createRole(@RequestBody Role role) {
        if( rolesService.createRole(role) > 0) return ApiResponse.success(null);
        return ApiResponse.error(304,"添加失败");
    }

    @PutMapping("/{roleId}")
    public ApiResponse updateRole(@PathVariable("roleId") Integer roleId, @RequestBody Role role) {
        role.setRoleId(roleId);
        if( rolesService.updateRole(role) > 0) return ApiResponse.success(null);
        return ApiResponse.error(304,"修改失败");
    }

    @DeleteMapping("/{roleId}")
    public ApiResponse deleteRoleById(@PathVariable("roleId") Integer roleId) {
        if( rolesService.deleteRoleById(roleId) > 0 ) return ApiResponse.success(null);
        return ApiResponse.error(304, "删除失败");
    }

}
