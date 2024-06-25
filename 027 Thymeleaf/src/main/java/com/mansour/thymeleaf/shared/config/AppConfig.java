package com.mansour.thymeleaf.shared.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({ OpenApiConfig.class })
@PropertySource("classpath:application.properties")
public class AppConfig {

}
