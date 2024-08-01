package com.ibrahim.orderservice.config;

import com.ibrahim.orderservice.interceptors.BasicAuthHandlerInterceptor;
import com.ibrahim.orderservice.interceptors.LogHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHandlerInterceptor())
                .order(2);
        registry.addInterceptor(new BasicAuthHandlerInterceptor())
                .order(1).addPathPatterns("/api/v1/order-service/add");
    }
}
