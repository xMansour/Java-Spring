package com.mansour.caching.shared.config;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.github.benmanes.caffeine.cache.Caffeine;

public class CaffeineConfig {
    @Bean
    public CaffeineCache customersCaffeineCacheConfig() {
        return new CaffeineCache("customersCache", Caffeine.newBuilder().expireAfterWrite(Duration.ofMinutes(1))
                .initialCapacity(1).maximumSize(2000).build());
    }

    @Bean
    public CaffeineCache customerCaffeineCacheConfig() {
        return new CaffeineCache("customerCache", Caffeine.newBuilder().expireAfterWrite(Duration.ofMinutes(1))
                .initialCapacity(1).maximumSize(2000).build());
    }

    @Bean
    @Primary
    public CacheManager caffeineCacheManager(
            @Qualifier("customersCaffeineCacheConfig") CaffeineCache customersCaffeineCache,
            @Qualifier("customerCaffeineCacheConfig") CaffeineCache customerCaffeineCache) {
        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(List.of(customersCaffeineCache, customerCaffeineCache));
        return manager;
    }

}
