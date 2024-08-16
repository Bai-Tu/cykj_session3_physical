package com.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @author 李璟瑜
 * @date 2024/8/1 11:08
 * @description:
 */
public class JwtUtil {
    private static final String privateKey = "aIQ41XOa8vSqvHIUZpW8fiwtFQDPoM4loR3iXkBfzMFOHEsLiZ4b7C6rLWobKyll";
    private static final long expTime = 30000000;

    public static String generateToken(Map<String,Object> claims){
        long nowTime = System.currentTimeMillis();
        Date date = new Date(nowTime + expTime);
        String token = Jwts.builder()
                .addClaims(claims)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS256, privateKey)
                .compact();
        return token;
    }

    public static Map<String,Object> parseToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(privateKey)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    public static Claims parseTokenInClaim(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(privateKey)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }



}
