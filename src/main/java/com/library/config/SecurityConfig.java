package com.library.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/addBook").authenticated()
            .antMatchers("/borrowBook/{bookId}").authenticated()
            .antMatchers("/library/status").authenticated()
            .antMatchers("/returnBook/{bookId}").authenticated()
            .antMatchers("/welcome").authenticated();
        http.formLogin();
        http.httpBasic();
    }
}
