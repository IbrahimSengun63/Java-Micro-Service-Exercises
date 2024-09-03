package com.ibrahim.userservice.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CacheInspector {
    @Autowired
    private final CacheManager cacheManager;

    public void inspectCache() {
        System.out.println("Cache Names: " + cacheManager.getCacheNames());
    }
}
