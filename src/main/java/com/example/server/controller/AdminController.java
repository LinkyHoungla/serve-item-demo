package com.example.server.controller;

import com.example.server.entity.Admin;
import com.example.server.entity.ApiResponse;
import com.example.server.entity.PageInfo;
import com.example.server.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping
    public ApiResponse<Admin> getAdminById(Integer account){
        Admin admin = adminService.getAdminById(account);
        if (admin == null) return ApiResponse.error(403, "未找到");
        return ApiResponse.success(admin);
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
