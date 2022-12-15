package com.lucas.azumy.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class CorsConfig {

    
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
        	
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowedOrigins("*");
                WebMvcConfigurer.super.addCorsMappings(registry);
            }
        };
    }
}