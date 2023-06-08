package com.example.server.controller;

import com.example.server.entity.Admin;
import com.example.server.entity.ApiResponse;
import com.example.server.entity.PageInfo;
import com.example.server.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping
    public ApiResponse<Admin> getAdminByName(String name){
        Admin admin = adminService.getAdminByName(name);
        if (admin == null) return ApiResponse.error(403, "未找到");
        return ApiResponse.success(admin);
    }

    @GetMapping("/sameName")
    public ApiResponse isSameName(String username) {
        if (adminService.getAdminByName(username) == null) return ApiResponse.success("用户名可用");
        return ApiResponse.error(201, "用户名已存在");
    }

    @PostMapping
    public ApiResponse addAdmin(@RequestBody Admin admin) {
        admin.setCreateAt(new Date());
        if( adminService.createAdmin(admin) > 0) return ApiResponse.success(null);
        return ApiResponse.error(304,"添加失败");
    }

    @GetMapping("/page")
    public ApiResponse<PageInfo> getAdminByPage(String query, Integer pageNum, Integer pageSize){
        List<Admin> adminList = adminService.getAdminByPage(query, pageNum, pageSize);
        Integer totalNum = adminService.getTotalNum(query);
        PageInfo pageInfo = PageInfo.success(totalNum, adminList);
        if (adminList == null) return ApiResponse.error(403, "未找到");
        return ApiResponse.success(pageInfo);
    }
}
