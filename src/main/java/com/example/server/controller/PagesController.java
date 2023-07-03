package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageTree;
import com.example.server.service.impl.PageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class PagesController {
    @Autowired
    private PageServiceImpl pageService;

    @GetMapping("/pageTree")
    public ApiResponse<List<PageTree>> getRights() {
        return ApiResponse.success(pageService.getPageTree());
    }

    @GetMapping("/menu")
    public ApiResponse<List<Menu>> getMenus(HttpServletRequest request) {
        return ApiResponse.success(pageService.getAdminMenu((String)request.getAttribute("role")));
    }

}
