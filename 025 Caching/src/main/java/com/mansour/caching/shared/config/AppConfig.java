package com.mansour.caching.shared.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ CaffeineConfig.class, RedisConfig.class, OpenApiConfig.class })
@EnableCaching
public class AppConfig {

}
