package com.example.authenticatioserver.config;

import com.example.authenticatioserver.service.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@EnableWebSecurity
public class DefaultSecurityConfig {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                        authorizeRequests
                            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                            .antMatchers("/api/register", "/api/access").permitAll()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());

        http.csrf()
            .disable();
//        http.cors();
        return http.build();
    }

    List<String> allowedMethods = Arrays.asList("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public FilterRegistrationBean corsWebFilter(){
        System.out.println("Second Filterbean");
        CorsConfiguration config = new CorsConfiguration();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://127.0.0.1:4200/");
        config.setAllowedHeaders(List.of("accept-language","Origin", "Authorization", "Content-Type", "Accept", "X-Requested-with", "Access-Control-Request-Method", "Access-Control-Request-Headers", "application/x-www-form-urlencoded"));
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowCredentials(true);
//        configuration.addAllowedOrigin("http://127.0.0.1:4200");
//        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        configuration.setAllowedMethods(allowedMethods);
//        configuration.addExposedHeader("Authorization");
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

    @Autowired
    public void bindAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder
                .authenticationProvider(customAuthenticationProvider);
    }
}
