package com.onyx.springbootdemo.config;

import com.onyx.springbootdemo.service.LoginSuccessHandler;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
                // Authorization config for home2
                .antMatchers("/home2").hasRole("user")
                .anyRequest().fullyAuthenticated();
    }

    // @Override
    // protected UserDetailsService userDetailsService() {
    //     InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    //     manager.createUser(User.withUsername("admin").password("admin").roles("user").build());
    //     return manager;
    // }
}
