package com.ibrahim.userservice.webApi.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/user-service/session")
@RequiredArgsConstructor
public class SessionController {
    private final StringRedisTemplate redisTemplate;

    @GetMapping("/inspect")
    public ResponseEntity<Map<String, Object>> inspectSession(HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Get session attributes
        request.getSession().getAttributeNames().asIterator().forEachRemaining(name -> {
            response.put(name, request.getSession().getAttribute(name));
        });

        // Get cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                response.put("cookie:" + cookie.getName(), cookie.getValue());
            }
        }

        // Fetch tokens from Redis
        Set<String> tokens = redisTemplate.keys("token:*");
        if (tokens != null && !tokens.isEmpty()) {
            for (String tokenKey : tokens) {
                String tokenValue = redisTemplate.opsForValue().get(tokenKey);
                response.put(tokenKey, tokenValue);
            }
        }
        // Fetch username from Redis
        String token = extractTokenFromHeader(request);
        if (token != null) {
            String tokenInRedis = redisTemplate.opsForValue().get("token:" + token);
            response.put("token", tokenInRedis);
        }

        // Return the session attributes, cookies, and token as a ResponseEntity
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private String extractTokenFromHeader(HttpServletRequest request) {
        String jwtHeader = request.getHeader("Authorization");
        if (jwtHeader != null && jwtHeader.startsWith("Bearer ")) {
            return jwtHeader.substring(7);
        }
        return null;
    }
}
