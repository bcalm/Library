package com.library.config;

import com.library.filter.AuthoritiesLoggingAfterFilter;
import com.library.filter.AuthoritiesLoggingAtFilter;
import com.library.filter.JWTTokenGeneratorFilter;
import com.library.filter.JWTTokenValidatorFilter;
import com.library.filter.RequestValidationBeforeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import static java.util.Collections.singletonList;

@Configuration
@Slf4j
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .cors().configurationSource(request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(singletonList("http://localhost:4200"));
                config.setAllowedMethods(singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(singletonList("*"));
                config.setExposedHeaders(singletonList("Authorization"));
                config.setMaxAge(3600L);
                return config;
            }).and().csrf().disable()
            .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
            .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
            .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
            .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
            .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
            .authorizeHttpRequests((auth) -> auth
                .antMatchers("/addBook").authenticated()
                .antMatchers("/borrowBook/{bookId}").authenticated()
                .antMatchers("/library/status").authenticated()
                .antMatchers("/returnBook/{bookId}").authenticated()
                .antMatchers("/user").authenticated()
                .antMatchers("/welcome").authenticated()
            )
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
