package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageTree;
import com.example.server.service.impl.RightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RightController {
    @Autowired
    private RightServiceImpl pageService;

    @GetMapping("/pageTree")
    public ApiResponse<List<PageTree>> getRights() {
        return ApiResponse.success(pageService.getPageTree());
    }

    @GetMapping("/menu")
    public ApiResponse<List<Menu>> getMenus(HttpServletRequest request) {
        return ApiResponse.success(pageService.getAdminMenu((String)request.getAttribute("role")));
    }

}
