package com.onyx.springbootdemo.config;

import com.onyx.springbootdemo.service.LoginSuccessHandler;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Slf4j
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin().loginPage("/login").permitAll();
        http.formLogin().successHandler(new LoginSuccessHandler());
        http.logout().permitAll();
        http.authorizeRequests()
                .antMatchers("/js/**", "/css/**", "/images/**").permitAll()
                .antMatchers("/add/**").permitAll()
                .anyRequest().fullyAuthenticated();
    }
}
