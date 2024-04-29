package com.mansour;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public Employee employee(){
        return new Employee();
    }

    @Bean
    public Department department(){
        return new Department("IT");
    }
}
