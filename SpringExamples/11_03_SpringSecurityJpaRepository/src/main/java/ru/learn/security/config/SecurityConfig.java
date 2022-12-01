package ru.learn.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain mySecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeRequests()

                //можно инициализировать тут или в самом контроллере с помощь @Secured
//                .antMatchers("/app/admin-page").hasRole("ADMIN")
//                .antMatchers("/app/user-page").hasAnyRole("USER", "ADMIN")

                .antMatchers("/app/home").authenticated()

                // дает указание, что тем url на которые не указать принудительно правила авторизации,
                // то они по умолчанию будут требовать авторизоваться пользователя
                .anyRequest().authenticated()
//                .antMatchers("/app/guest").permitAll()
                .and()
                .formLogin()
                .and()
                .build();
    }

//    Можно указать в качестве бина экодера BCryptPasswordEncoder, тогда пароль автоматом им кодируется
//    и бд уже должно лежать закодированное им значение, так называемый хэш пароля
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }

}
