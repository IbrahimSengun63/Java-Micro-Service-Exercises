package com.ibrahim.orderservice.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class BasicAuthHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("BasicAuthHandlerInterceptor::preHandle");

        String authHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Basic ")) {
            String base64Cred = authHeader.substring("Basic ".length());
            byte[] decodeCred = Base64.getDecoder().decode(base64Cred);
            String creds = new String(decodeCred, StandardCharsets.UTF_8);
            String[] parts = creds.split(":");
            if ("admin".equals(parts[0]) && "admin".equals(parts[1])) {
                return true;
            }
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("BasicAuthHandlerInterceptor::postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("BasicAuthHandlerInterceptor::afterCompletion");
    }
}
