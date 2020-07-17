package com.example.deretopic.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/img/**", "/js/**",
                        "/h2/**", "/h2-console/**", "/favicon.ico",
                        "/index.html", "/api/**").permitAll()

                .anyRequest().authenticated()

                .and()
                .logout().logoutSuccessUrl("/");


    }

}
