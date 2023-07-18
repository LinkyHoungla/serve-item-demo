package com.example.server.controller;

import com.example.server.constant.ApiError;
import com.example.server.exception.ApiException;
import com.example.server.model.ApiResponse;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageTree;
import com.example.server.service.impl.RightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RightController {
    @Autowired
    private RightServiceImpl pageService;

    @GetMapping("/page/{type}")
    public ApiResponse<List<?>> getRights(@PathVariable("type")String type) {
        if (type.equals("tree"))
            return ApiResponse.success(pageService.getPageTree());
        if (type.equals("list"))
            return ApiResponse.success(pageService.getPageList());
        throw new ApiException(ApiError.E404);
    }

    @GetMapping("/menu")
    public ApiResponse<List<Menu>> getMenus(HttpServletRequest request) {
        return ApiResponse.success(pageService.getAdminMenu((Integer)request.getAttribute("roleId")));
    }

    @GetMapping("/rights/{roleId}")
    public ApiResponse<List<PageTree>> getRoleRights(@PathVariable("roleId") Integer roleId) {
        return ApiResponse.success(pageService.getRoleRights(roleId));
    }

}
