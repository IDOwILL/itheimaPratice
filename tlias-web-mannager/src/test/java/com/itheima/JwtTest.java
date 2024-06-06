package com.itheima;

import com.itheima.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;


public class JwtTest {
    @Test
    public void generate() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 123);
        map.put("username", "Tom");
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, "REWR123")
                .addClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 1000000000))
                .compact();//生成
        System.out.println(token);
    }

    @Test
    public void parseToken() {
        String token="eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MTIzLCJ1c2VybmFtZSI6IlRvbSIsImV4cCI6MTcxODY0MzYwMX0.kJct5y86hth0aFos6pgRyes182uaoPBrkUGXk9VPa0c";
        Claims claims = Jwts.parser().setSigningKey("REWR123")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);


    }
}
