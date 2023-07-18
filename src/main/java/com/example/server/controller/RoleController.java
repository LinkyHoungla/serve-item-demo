package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.entity.Role;
import com.example.server.service.impl.RoleServiceImpl;
import io.swagger.models.auth.In;
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

    @GetMapping("/name")
    public ApiResponse<String> getRoleNameById(Integer roleId){
        System.out.println(roleId);
        return ApiResponse.success(rolesService.getRoleNameById(roleId));
    }

    @PostMapping
    public ApiResponse<Integer> createRole(@RequestBody Role role) {
        return ApiResponse.success(rolesService.createRole(role));
    }

    @PutMapping
    public ApiResponse<Integer> updateRole(@RequestBody Role role) {
        return ApiResponse.success(rolesService.updateRole(role));
    }

    @DeleteMapping("/{roleId}")
    public ApiResponse<Integer> deleteRoleById(@PathVariable("roleId") Integer roleId) {
        return ApiResponse.success(rolesService.deleteRoleById(roleId));
    }

}
