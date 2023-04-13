package com.iot.petplate.security;

import com.iot.petplate.dto.UserDTO;
import com.project.util.UtilJson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final String ACCESS_TOKEN_SECRET = "8778516a6da4e71ce8b5902d710e10891279148da692be0371af1e8aacd2f20b";
    private static final Long ACCESS_TOKEN_VALIDITY_SECONDS = 3_600L;

    private TokenUtil() {
    }

    public static String createToken(UserDTO userDTO) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("user", UtilJson.getGson().toJson(userDTO));

        return Jwts.builder()
                .setSubject(userDTO.getEmail())
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String userJson = claims.get("user", String.class);
            UserDTO userDTO = UtilJson.getGson().fromJson(userJson, UserDTO.class);
            return new UsernamePasswordAuthenticationToken(userDTO, null, Collections.emptyList());
        } catch (JwtException jwtException) {
            return null;
        }
    }
}
