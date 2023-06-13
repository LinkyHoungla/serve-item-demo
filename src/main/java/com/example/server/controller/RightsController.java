package com.example.server.controller;

import com.example.server.entity.ApiResponse;
import com.example.server.entity.Menus;
import com.example.server.entity.Rights;
import com.example.server.service.impl.RightsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RightsController {
    @Autowired
    private RightsServiceImpl rightsServiceImpl;

    @GetMapping("/menus")
    public ApiResponse<List<Menus>> getMenus() {
        List<Menus> menusList = rightsServiceImpl.getMenus();
        if(menusList == null) return ApiResponse.error(201,"错误");
        return ApiResponse.success(menusList);
    }

    @GetMapping("/rights/{type}")
    public ApiResponse<List<Rights>> getRights(@PathVariable("type") String type) {
        if(type.equals("tree")) {
            List<Rights> rightsList = rightsServiceImpl.getRightsTree();
            if (rightsList == null) return ApiResponse.error(201, "错误");
            return ApiResponse.success(rightsList);
        }else if(type.equals("list")){
            List<Rights> rightsList = rightsServiceImpl.getRightsList();
            if (rightsList == null) return ApiResponse.error(201, "错误");
            return ApiResponse.success(rightsList);
        }
        return ApiResponse.error(404,"未知类型");
    }
}
