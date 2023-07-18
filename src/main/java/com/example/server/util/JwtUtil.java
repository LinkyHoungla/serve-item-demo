package com.example.server.util;

import com.example.server.model.vo.LoginDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JwtUtil {
    // 10min过期
    private static final long EXPIRE = 60 * 10;
    // 32位密钥
    private static final String SECRET = "AaBbCcDdKinvaLinkyLoveYing123456";
    // token前缀
    private static final String TOKEN_PREFIX = "Bearer ";
    // 请求头参数名
    private static final String HEADER_STRING = "Authorization";
    // JWT黑名单
    // todo：后续使用redis完成对应功能，目前只是简单测试
    private static final List<String> revokedTokens = new ArrayList<>();

    // 生成Token
    public static String generateToken(LoginDetail loginDetail) {
        // 设置有效期
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * EXPIRE);

        Claims claims = Jwts.claims().setSubject(loginDetail.getUsername());
        claims.put("uid", loginDetail.getUid());
        claims.put("roleId", loginDetail.getRoleId());
        claims.put("ip", loginDetail.getIp());

        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                // .setSubject(username)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    // 解析token
    public static Claims getClaimsByToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    // 解析请求头token
    public static String extractTokenFromRequest(HttpServletRequest request) {
        // 从请求头或请求参数中获取令牌
        String token = request.getHeader(HEADER_STRING);
        if (token != null && token.startsWith(TOKEN_PREFIX)) {
            return token.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    // 将令牌添加至失效名单
    public static void revokedToken(String token) {
        revokedTokens.add(token);
    }

    // 检查令牌是否在撤销令牌列表中
    public static boolean isTokenRevoked(String token) {
        return revokedTokens.contains(token);
    }
}
