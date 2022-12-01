package ru.learn.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain mySecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeRequests()
                .antMatchers("/app/admin-page").hasRole("ADMIN")
                .antMatchers("/app/user-page").hasAnyRole("USER", "ADMIN")
                .antMatchers("/app/home").authenticated()
                .antMatchers("/app/guest").permitAll()
                .and()
                .formLogin()
                .and()
                .build();
    }

}
