//package com.example.authenticatioserver.config;
//
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class TestCorsFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        System.out.println("Testfilter");
//        if(!(request instanceof ContentCachingRequestWrapper)){
//            request = new ContentCachingRequestWrapper(request);
//        }
//
//        String origin = request.getHeader("Origin");
//        response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:4200");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, Authorization, Content-Type, Accept, X-Requested-with, Access-Control-Request-Method, Access-Control-Request-Headers, application/x-www-form-urlencoded");
//
//
//        CorsConfiguration config = new CorsConfiguration();
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://127.0.0.1:4200/");
//        config.setAllowedHeaders(List.of("accept-language","Origin", "Authorization", "Content-Type", "Accept", "X-Requested-with", "Access-Control-Request-Method", "Access-Control-Request-Headers", "application/x-www-form-urlencoded"));
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//
//        if("OPTIONS".equalsIgnoreCase(request.getMethod())){
//            response.setStatus(HttpStatus.OK.value());
//        }else {
//            filterChain.doFilter(request,servletResponse);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
