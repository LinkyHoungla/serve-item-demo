package com.example.server.controller;

import com.example.server.constant.ApiError;
import com.example.server.exception.ApiException;
import com.example.server.model.ApiResponse;
import com.example.server.model.param.PageParam;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageTree;
import com.example.server.service.impl.RightServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RightController {
    @Autowired
    private RightServiceImpl pageService;

    @GetMapping("/page/tree")
    public ApiResponse<?> getRightTree(@RequestParam(defaultValue = "3")Integer level) {
        return ApiResponse.success(pageService.getPageTree(level));
    }

    @GetMapping("/page/list")
    public ApiResponse<PageInfo<PageTree>> getRightsList(String query,
                                               @RequestParam(defaultValue = "1")Integer pageNum,
                                               @RequestParam(defaultValue = "10")Integer pageSize) {
        return ApiResponse.success(pageService.getPageTreeByPage(query, pageNum, pageSize));
    }

    @GetMapping("/menu")
    public ApiResponse<List<Menu>> getMenus(HttpServletRequest request) {
        return ApiResponse.success(pageService.getAdminMenu((Integer)request.getAttribute("roleId")));
    }

    @GetMapping("/rights/{roleId}")
    public ApiResponse<List<PageTree>> getRoleRight(@PathVariable("roleId") Integer roleId) {
        return ApiResponse.success(pageService.getRoleRights(roleId));
    }

    @GetMapping("/rights/list/{roleId}")
    public ApiResponse<List<Integer>> getRightsId(@PathVariable("roleId") Integer roleId) {
        return ApiResponse.success(pageService.getRightsIdList(roleId));
    }

    @PostMapping("/page")
    public ApiResponse<Integer> addPage(@RequestBody PageParam param) {
        return ApiResponse.success(pageService.addPage(param));
    }

    @DeleteMapping("/page/{pageId}")
    public ApiResponse<Integer> deletePage(@PathVariable("pageId") Integer pageId) {
        return ApiResponse.success(pageService.deletePage(pageId));
    }

    @PostMapping("/rights/{roleId}")
    public ApiResponse<Integer> addRights(@PathVariable("roleId") Integer roleId, @RequestBody List<Integer> rights) {
        System.out.println(rights);
        return ApiResponse.success(pageService.addRights(roleId, rights));
    }

    @DeleteMapping("/right/roleId/{roleId}/pageId/{pageId}")
    public ApiResponse<Integer> deleteRoleRight(@PathVariable("roleId") Integer roleId, @PathVariable("pageId") Integer pageId) {
        return ApiResponse.success(pageService.deleteRight(pageId, roleId));
    }

    @PutMapping("/page/{pageId}")
    public ApiResponse<Integer> updatePage(@PathVariable("pageId")Integer pageId, @RequestBody PageParam param){
        return ApiResponse.success(pageService.updatePage(param, pageId));
    }

}
