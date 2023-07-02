package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.param.LoginParam;
import com.example.server.service.impl.AdminServiceImpl;
import com.example.server.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LogController {
    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping ("/login/admin")
    public ApiResponse<Map<String, Object>> loginAdmin(@RequestBody LoginParam info, HttpServletRequest request){
        String token = adminService.loginAdmin(info.getUsername(), info.getPassword(), request.getRemoteAddr());
        Map<String, Object> set = new HashMap<>();
        set.put("token", token);
        return ApiResponse.success(set);
    }

    @PostMapping("/logout/admin")
    public ApiResponse logoutAdmin(HttpServletRequest request){
        String token = JwtUtil.extractTokenFromRequest(request);
        if (token != null) {
            // 标记令牌为无效，使其失效
            JwtUtil.revokedToken(token);
        }

        // 返回登出成功的响应
        return ApiResponse.success("已退出登录");
    }
}
