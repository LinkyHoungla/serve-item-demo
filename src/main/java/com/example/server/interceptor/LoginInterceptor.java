package com.example.server.interceptor;

import com.example.server.constant.ApiError;
import com.example.server.exception.ApiException;
import com.example.server.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    // 登录校验拦截器
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            // 从请求头获取 jwt
            String jwt = JwtUtil.extractTokenFromRequest(request);
            if (jwt == null || JwtUtil.isTokenRevoked(jwt)) throw new ApiException(ApiError.E401);

            // 解析和验证 JWT
            Claims claims = JwtUtil.getClaimsByToken(jwt);

            // 在解析后的 Claims 中获取用户信息
            String id = claims.getSubject();
            String ip = claims.get("ip", String.class);
            Integer roleId = claims.get("roleId", Integer.class);


            // TODO: 根据需要进行其他逻辑处理
            request.setAttribute("id", id);
            request.setAttribute("ip", ip);
            request.setAttribute("roleId", roleId);

            System.out.print(id + "--");
            System.out.print(roleId + "--");
            System.out.println(ip);

        } catch (ExpiredJwtException | ApiException e) {
            throw new ApiException(ApiError.E451);
        } catch (MalformedJwtException e) {
            throw new ApiException(ApiError.E450);
        } catch (SignatureException e) {
            throw new ApiException(ApiError.E401);
        }

        // 校验通过，允许请求继续访问后续拦截器
        return true;
    }
}
