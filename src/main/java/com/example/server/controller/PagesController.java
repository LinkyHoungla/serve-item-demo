package com.example.server.controller;

import com.example.server.entity.ApiResponse;
import com.example.server.entity.Menus;
import com.example.server.entity.Pages;
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

    @GetMapping("/menus")
    public ApiResponse<List<Menus>> getMenus() {
        List<Menus> menusList = rightsServiceImpl.getMenus();
        if(menusList == null) return ApiResponse.error(201,"错误");
        return ApiResponse.success(menusList);
    }

    @GetMapping("/rights/{type}")
    public ApiResponse<List<Pages>> getRights(@PathVariable("type") String type) {
        if(type.equals("tree")) {
            List<Pages> pagesList = rightsServiceImpl.getRightsTree();
            if (pagesList == null) return ApiResponse.error(201, "错误");
            return ApiResponse.success(pagesList);
        }else if(type.equals("list")){
            List<Pages> pagesList = rightsServiceImpl.getRightsList();
            if (pagesList == null) return ApiResponse.error(201, "错误");
            return ApiResponse.success(pagesList);
        }
        return ApiResponse.error(404,"未知类型");
    }
}
