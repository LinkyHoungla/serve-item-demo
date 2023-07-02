package com.example.server.util;

import com.example.server.constant.ApiError;
import com.example.server.exception.ApiException;
import io.jsonwebtoken.*;

import java.util.Date;

public class JwtUtil {
    // 7天过期
    private static long expire = 604800;

    // 32位密钥
    private static String secret = "AaBbCcDdKinvaLinkyLoveYing123456";

    // 生成Token
    public static String generateToken(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * expire);
        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    // 解析token
    public static Claims getClaimsByToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
