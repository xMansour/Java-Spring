package com.mansour.lombok.shared.config;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import com.github.benmanes.caffeine.cache.Caffeine;

public class CaffeineCasheConfig {
    @Bean
    public CaffeineCache employeesCaffeineCacheConfig() {
        return new CaffeineCache("employeesCache", Caffeine.newBuilder()
                .initialCapacity(1).maximumSize(2000)
                .expireAfterWrite(Duration.ofMinutes(1)).build());
    }

    @Bean
    public CaffeineCache employeeCaffeineCacheConfig() {
        return new CaffeineCache("employeeCache", Caffeine.newBuilder()
                .initialCapacity(1).maximumSize(2000)
                .expireAfterWrite(Duration.ofMinutes(1)).build());
    }

    @Bean
    public CacheManager caffeineCacheManager(
            @Qualifier("employeesCaffeineCacheConfig") CaffeineCache employeesCaffeineCacheConfig,
            @Qualifier("employeeCaffeineCacheConfig") CaffeineCache employeeCaffeineCacheConfig) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(List.of(employeesCaffeineCacheConfig, employeeCaffeineCacheConfig));
        return cacheManager;

    }

}
