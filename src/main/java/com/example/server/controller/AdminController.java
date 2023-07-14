package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.param.AdminParam;
import com.example.server.model.param.LoginParam;
import com.example.server.model.vo.AdminInfoWithRole;
import com.example.server.model.vo.LoginAdminVo;
import com.example.server.service.impl.AdminServiceImpl;
import com.example.server.util.JwtUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping ("/login")
    public ApiResponse<Map<String, Object>> loginAdmin(@RequestBody LoginParam info, HttpServletRequest request){
        String token = adminService.loginAdmin(info.getUsername(), info.getPassword(), request.getRemoteAddr());
        Map<String, Object> set = new HashMap<>();
        set.put("token", token);
        return ApiResponse.success(set);
    }

    @PostMapping("/logout")
    public ApiResponse logoutAdmin(HttpServletRequest request){
        String token = JwtUtil.extractTokenFromRequest(request);
        if (token != null) {
            // 标记令牌为无效，使其失效
            JwtUtil.revokedToken(token);
        }

        // 返回登出成功的响应
        return ApiResponse.success("已退出登录");
    }

    @GetMapping("/info")
    public ApiResponse<LoginAdminVo> getAdminInfo(HttpServletRequest request) {
        LoginAdminVo loginAdminVo = adminService.getLoginAdminVo((Integer) request.getAttribute("uid"));
        return ApiResponse.success(loginAdminVo);
    }

    @GetMapping("/page")
    public ApiResponse<PageInfo<AdminInfoWithRole>> getAdminByPage(String query,
                                                                   @RequestParam(defaultValue = "1")Integer pageNum,
                                                                   @RequestParam(defaultValue = "10")Integer pageSize){
        return ApiResponse.success(adminService.getAdminsByPage(query, pageNum, pageSize));
    }

    @GetMapping("/sameName")
    public ApiResponse isSameName(String username) {
        if (adminService.getAdminLoginByName(username) == null) return ApiResponse.success("用户名可用");
        return ApiResponse.error(201, "用户名已存在");
    }

    @PostMapping
    public ApiResponse addAdmin(@RequestBody AdminParam adminParam) {
        return ApiResponse.success(adminService.addAdminInfo(adminParam));
    }

    @PutMapping
    public ApiResponse updateAdmin(@RequestBody AdminParam adminParam) {
        return ApiResponse.success(adminService.updateAdminInfo(adminParam));
    }

    @DeleteMapping("/{adminId}")
    public ApiResponse deleteAdminById(@PathVariable("adminId") Integer id) {
        adminService.deleteAdminInfoById(id);
        return ApiResponse.success(null);
    }
}
