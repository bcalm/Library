package com.library.config;

import com.library.filter.AuthoritiesLoggingAfterFilter;
import com.library.filter.AuthoritiesLoggingAtFilter;
import com.library.filter.RequestValidationBeforeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
            .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
            .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
            .authorizeRequests()
            .antMatchers("/addBook").authenticated()
            .antMatchers("/borrowBook/{bookId}").authenticated()
            .antMatchers("/library/status").authenticated()
            .antMatchers("/returnBook/{bookId}").authenticated()
            .antMatchers("/welcome").hasRole("ADMIN");
        http.formLogin();
        http.httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("Vikram").password("123456").authorities("admin").build();
//        UserDetails user2 = User.withUsername("Vikram").password("12345").authorities("read").build();
//        userDetailService.createUser(user);
//        userDetailService.createUser(user2);
//        auth.userDetailsService(userDetailService);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
