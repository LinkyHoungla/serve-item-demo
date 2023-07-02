package com.example.server.interceptor;

import com.example.server.constant.ApiError;
import com.example.server.exception.ApiException;
import com.example.server.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_STRING = "Authorization";

    // 登录校验拦截器
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头获取 JWT
        String token = request.getHeader(HEADER_STRING);

        // 验证JWT token的有效性
        if (token != null && token.startsWith(TOKEN_PREFIX)) {
            try {
                // 去除前缀 "Bearer "
                String jwt = token.substring(TOKEN_PREFIX.length());

                // 解析和验证 JWT
                Claims claims = JwtUtil.getClaimsByToken(jwt);

                // 在解析后的 Claims 中获取用户信息
                String username = claims.getSubject();
                System.out.println(username);

                // TODO: 根据需要进行其他逻辑处理

            }catch (ExpiredJwtException e) {
                throw new ApiException(ApiError.E451);
            } catch (MalformedJwtException e) {
                throw new ApiException(ApiError.E450);
            }
        }else {
            throw new ApiException(ApiError.E401);
        }

        // 校验通过，允许请求继续访问后续拦截器
        return true;
    }
}
