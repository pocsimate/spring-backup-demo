package com.example.demo.config;

import com.example.demo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public LoggingInterceptor produceLoggingInterceptor() {
        return new LoggingInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO: filtering endpoints, in other words different interceptor for each functionality
        registry.addInterceptor(produceLoggingInterceptor());
    }
}
