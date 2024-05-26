package com.mansour.lombok.shared.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableCaching
@Import({ OpenApiConfig.class, CaffeineCasheConfig.class })
public class AppConfig {

}
