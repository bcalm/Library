package com.library.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;

@Configuration
@Slf4j
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        http.cors().configurationSource(request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setMaxAge(3600L);
                return config;
            }).and().authorizeHttpRequests((auth) -> auth
                .antMatchers("/addBook").hasRole("USER")
                .antMatchers("/status").hasAnyRole("ADMIN")
                .antMatchers("/borrowBook").authenticated()
                .antMatchers("/welcome").authenticated()
                .antMatchers("/returnBook").hasAnyRole("USER", "ADMIN"))
            .csrf().disable()
            .oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);

        http.headers().frameOptions().sameOrigin();
        return http.build();
    }
}
