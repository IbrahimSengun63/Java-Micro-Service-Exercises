package com.ibrahim.orderservice.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
@Slf4j
public class ReqResLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest request) {
            log.info("ReqResLoggingFilter::Logging Request  {} : {}", request.getMethod(), request.getRequestURI());
        }

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("ReqResLoggingFilter::Logging Response :{}", servletResponse.getContentType());
    }
}
