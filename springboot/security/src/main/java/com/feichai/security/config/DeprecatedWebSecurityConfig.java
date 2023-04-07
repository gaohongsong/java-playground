package com.feichai.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class DeprecatedWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.authenticationProvider(authenticationProvider());
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("12345")).roles("teacher")
                .and()
                .withUser("admin").password(passwordEncoder().encode("12345")).roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.formLogin()
                .loginPage("/loginPage")
                .loginProcessingUrl("/login")
                //登录失败跳转
                .failureUrl("/exception")
                //登录成功跳转
                .defaultSuccessUrl("/index", true);

        http.authorizeRequests()
                .antMatchers("/loginPage", "/hello", "/exception", "/*.jpg").permitAll()
                .anyRequest().authenticated();

        http.logout().logoutUrl("/logout");
        http.logout().permitAll();

        http.rememberMe()
                .tokenRepository(persistentTokenRepository)
                // 10s
                .tokenValiditySeconds(10)
                .userDetailsService(userDetailsService);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setHideUserNotFoundExceptions(false);
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
