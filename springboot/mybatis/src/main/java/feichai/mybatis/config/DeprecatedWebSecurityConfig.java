package feichai.mybatis.config;

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
        auth.authenticationProvider(authenticationProvider());

        // another way
        // auth.userDetailsService(userDetailsService)
        //         .passwordEncoder(myPasswordEncoder());

        // test only
        // auth.inMemoryAuthentication()
        //         .withUser("user").password(myPasswordEncoder().encode("12345")).roles("teacher")
        //         .and()
        //         .withUser("admin").password(myPasswordEncoder().encode("12345")).roles("admin");
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

        http.logout().logoutUrl("/logout").permitAll();

        http.rememberMe()
                .tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(60 * 60)
                .userDetailsService(userDetailsService);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setHideUserNotFoundExceptions(false);
        provider.setPasswordEncoder(myPasswordEncoder());
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }

    @Bean
    public PasswordEncoder myPasswordEncoder() {
        // 根据密码选择encoder（比如，可以识别明文密码：{noop}）?
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // @Bean
    // public BCryptPasswordEncoder myPasswordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
}
