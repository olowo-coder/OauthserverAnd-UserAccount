package com.example.authenticatioserver.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Configuration
public class WebConfig{


//    @Bean
//    public WebMvcConfigurer getCores(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                    .allowedOriginPatterns("http://127.0.0.1:4200")
//                    .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
//                    .allowedHeaders("*");
//            }
//        };
//    }



//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public FilterRegistrationBean corsWebFilter2(){
//        return new FilterRegistrationBean<>((servletRequest, servletResponse, filterChain) ->{
//            HttpServletRequest request = (HttpServletRequest) servletRequest;
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//            if(!(request instanceof ContentCachingRequestWrapper)){
//                request = new ContentCachingRequestWrapper(request);
//            }
//
//            System.out.println("FilterBean");
//            String origin = request.getHeader("Origin");
//            response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:4200");
//            response.setHeader("Access-Control-Allow-Credentials", "true");
//            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
//            response.setHeader("Access-Control-Allow-Headers", "Origin, Authorization, Content-Type, Accept, X-Requested-with, Access-Control-Request-Method, Access-Control-Request-Headers, application/x-www-form-urlencoded");
//
//            if("OPTIONS".equalsIgnoreCase(request.getMethod())){
//                response.setStatus(HttpStatus.OK.value());
//            }else {
//                filterChain.doFilter(request,servletResponse);
//            }
//        });
//    }

}
