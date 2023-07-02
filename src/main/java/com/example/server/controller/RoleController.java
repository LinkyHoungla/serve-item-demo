package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.Role;
import com.example.server.service.impl.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RolesServiceImpl rolesService;

    @GetMapping
    public ApiResponse<List<Role>> getAllRoles(){
        List<Role> roleList = rolesService.getAllRoles();
        if(roleList != null) return ApiResponse.success(roleList);
        return ApiResponse.error(404, "未查询到内容");
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
