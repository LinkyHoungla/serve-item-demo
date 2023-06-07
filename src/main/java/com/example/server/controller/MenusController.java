package com.example.server.controller;

import com.example.server.entity.ApiResponse;
import com.example.server.entity.Menus;
import com.example.server.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenusController {
    @Autowired
    private MenusService menusService;

    @GetMapping("/menus")
    public ApiResponse<List<Menus>> getMenus() {
        List<Menus> menusList = menusService.getMenus();
        if(menusList == null) return ApiResponse.error(201,"错误");
        return ApiResponse.success(menusList);
    }
}
