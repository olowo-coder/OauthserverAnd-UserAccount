package com.example.authenticatioserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AuthenticatioServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticatioServerApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/login/oauth2/**").allowedOrigins("http://127.0.0.1:4200")
//                    .allowedOriginPatterns("http://127.0.0.1:4200");
//            }
//        };
//    }

}
