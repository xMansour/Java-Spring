package com.mansour.webclient.shared.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@PropertySource(value = "application.properties")
public class WebClientConfig {
    @Value("${json-placeholder.base-url}")
    private String JSON_PLACEHOLDER_BASE_URL;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(JSON_PLACEHOLDER_BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
