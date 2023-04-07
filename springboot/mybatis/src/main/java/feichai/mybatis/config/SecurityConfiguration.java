package feichai.mybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

// @Configuration
// @EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults());

        return http.build();
    }

    // @Bean
    // public InMemoryUserDetailsManager userDetailsService() {
    //     UserDetails user = User.withDefaultPasswordEncoder()
    //             .username("admin")
    //             .password("123456")
    //             .roles("USER")
    //             .build();
    //     return new InMemoryUserDetailsManager(user);
    // }
}