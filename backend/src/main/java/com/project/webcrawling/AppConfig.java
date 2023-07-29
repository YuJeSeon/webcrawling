package com.project.webcrawling;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaRepositories(basePackages = "com.project.webcrawling.repository")
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings (CorsRegistry registry) {
        registry.addMapping("/api/**").allowCredentials(true).allowedOrigins("http://localhost:3000");
    }
}
