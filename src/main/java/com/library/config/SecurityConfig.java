package com.library.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) -> (
            (ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests
                .antMatchers("/addBook").authenticated()
                .antMatchers("/welcome"))
            .permitAll());
        http.formLogin();
        http.httpBasic();
    }
}
