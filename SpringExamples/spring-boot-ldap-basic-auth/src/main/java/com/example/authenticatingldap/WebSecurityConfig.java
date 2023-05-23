package com.example.authenticatingldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin();

        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns("CN={0},CN=YourUsers,DC=test,DC=alex") // make default pattern to search user
                .userSearchBase("CN=YourUsers,DC=test,DC=alex") // base place to find users, if have userDn this you can not write
                .userSearchFilter("(CN={0})") // filter for search user
                .groupSearchBase("CN=Some-Base-Group,CN=YourUsers,DC=test,DC=alex") // base place to search user roles
                .groupSearchFilter("member={0}") // filter - which field contains information that user added to this group/role
                .contextSource()
                .url("ldap://server:389") // as default used 389 port
                .managerDn("CN=some_user,CN=Users,DC=test,DC=alex") //this admin user to connect to ldap
                .managerPassword("your-password"); // this admin user pass

    }


}