package com.anhnguyen.mtadminservice.util;

import com.anhnguyen.mtadminservice.common.CodeDefsJwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    protected static Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    public static String generate(Map<String, String> map) {
        try {
            String userId = map.get("user_id");
            String roles = map.get("roles");
            String deviceId = map.get("device_id");
            Claims claims = Jwts.claims()
                    .setSubject(userId);
            claims.put("roles", roles);
            claims.put("device_id",deviceId);
            Date date = new Date();

            return Jwts.builder()
                    .setClaims(claims)
                    .signWith(SignatureAlgorithm.HS512, CodeDefsJwt.SECRET)
                    .setIssuedAt(date)
                    .setExpiration(new Date(date.getTime() + CodeDefsJwt.TIME_TOKEN_EXPIRE))
                    .compact();
        } catch (Exception e) {
            logger.info("L?i {}", e.getMessage());
            return null;
        }

    }

    public static Map<String, String> validate(String token) {
        Map<String, String> map = new HashMap<>();
        Claims claims = Jwts.parser()
                .setSigningKey(CodeDefsJwt.SECRET)
                .parseClaimsJws(token)
                .getBody();

        map.put("user_id", claims.getSubject());
        map.put("roles", claims.get("roles").toString());
        map.put("device_id",claims.get("device_id").toString());
        return map;
    }
}
