package com.example.server.controller;

import com.example.server.model.entity.AdminInfo;
import com.example.server.model.ApiResponse;
import com.example.server.model.QueryPage;
import com.example.server.model.entity.Role;
import com.example.server.model.vo.LoginAdminVo;
import com.example.server.service.impl.AdminServiceImpl;
import com.example.server.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/{account}")
    public ApiResponse<AdminInfo> getAdminById(@PathVariable("account") Integer id){
        AdminInfo adminInfo = adminService.getAdminById(id);
        if (adminInfo == null) return ApiResponse.error(403, "未找到");
        return ApiResponse.success(adminInfo);
    }

    @GetMapping("/info")
    public ApiResponse<LoginAdminVo> getAdminInfo(HttpServletRequest request) {
        LoginAdminVo loginAdminVo = adminService.getLoginAdminVo((String) request.getAttribute("username"));
        return ApiResponse.success(loginAdminVo);
    }

    @GetMapping("/sameName")
    public ApiResponse isSameName(String username) {
        // if (adminService.getAdminByName(username) == null) return ApiResponse.success("用户名可用");
        return ApiResponse.error(201, "用户名已存在");
    }

    @PostMapping
    public ApiResponse addAdmin(@RequestBody AdminInfo adminInfo) {
        adminInfo.setCreateAt(new Date());
        if( adminService.createAdmin(adminInfo) > 0) return ApiResponse.success(null);
        return ApiResponse.error(304,"添加失败");
    }

    @PutMapping("/{account}")
    public ApiResponse updateAdmin(@PathVariable("account") Integer id) {
        return ApiResponse.error(304,"修改失败");
    }

    @DeleteMapping("/{account}")
    public ApiResponse deleteAdminById(@PathVariable("account") Integer id) {
        if( adminService.deleteAdminById(id) > 0 ) return ApiResponse.success(null);
        return ApiResponse.error(304, "删除失败");
    }

    @GetMapping("/page")
    public ApiResponse<QueryPage> getAdminByPage(String query, Integer pageNum, Integer pageSize){
        List<AdminInfo> adminInfoList = adminService.getAdminByPage(query, pageNum, pageSize);
        Integer totalNum = adminService.getTotalNum(query);
        QueryPage queryPage = QueryPage.success(totalNum, adminInfoList);
        if (adminInfoList == null) return ApiResponse.error(403, "未找到");
        return ApiResponse.success(queryPage);
    }
}
