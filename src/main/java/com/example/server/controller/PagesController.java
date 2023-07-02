package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.Menus;
import com.example.server.model.entity.Page;
import com.example.server.service.impl.AdminServiceImpl;
import com.example.server.service.impl.RightsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PagesController {
    @Autowired
    private RightsServiceImpl rightsServiceImpl;
    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/menus")
    public ApiResponse<List<Menus>> getMenus() {
        List<Menus> menusList = rightsServiceImpl.getMenus();
        if(menusList == null) return ApiResponse.error(201,"错误");
        return ApiResponse.success(menusList);
    }

    @GetMapping("/menus/{roleId}")
    public ApiResponse<List<Menus>> getMenusByRoleId(@PathVariable("roleId") String name) {
        // List<Menus> menusList = rightsServiceImpl.getMenusById(adminService.getAdminByName(name).getAdminId());
        // if(menusList == null) return ApiResponse.error(201,"错误");
        return ApiResponse.success(null);
    }

    @GetMapping("/rights/{type}")
    public ApiResponse<List<Page>> getRights(@PathVariable("type") String type) {
        if(type.equals("tree")) {
            List<Page> pageList = rightsServiceImpl.getRightsTree();
            if (pageList == null) return ApiResponse.error(201, "错误");
            return ApiResponse.success(pageList);
        }else if(type.equals("list")){
            List<Page> pageList = rightsServiceImpl.getRightsList();
            if (pageList == null) return ApiResponse.error(201, "错误");
            return ApiResponse.success(pageList);
        }
        return ApiResponse.error(404,"未知类型");
    }

    @GetMapping("/right/{roleId}")
    public ApiResponse<List<Page>> getRightsById(@PathVariable("roleId") Integer roleId) {
        List<Page> pageList = rightsServiceImpl.getRightsList();
        if (pageList == null) return ApiResponse.error(201, "错误");
        return ApiResponse.success(pageList);
    }
}
