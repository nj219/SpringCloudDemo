package com.nj.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @Author 牛杰
 * @Date 2019/3/1 14:08
 * @ClassName:JwtUtil
 */
public class JwtUtil {
    @Value("${jwt.signName}")
    private String signName;

    /**
     * 用户登陆成功后得到token
     * @param id
     * @param name
     * @param role  角色
     * @return
     */
    public String createToken(String id, String name, String role) {
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,signName)
                .setId(id)
                .setSubject(name)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60))
                .claim("role",role)
                .compact();
        return token;
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public Claims parsetToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("itcast")
                    .parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            throw new RuntimeException("token出错");
        }
    }
}
