package com.library.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("12345").authorities("admin")
            .and().withUser("Vikram").password("12345").authorities("read")
            .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
