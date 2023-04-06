package com.onyx.springbootdemo;

import com.onyx.springbootdemo.dao.UserRepository;
import com.onyx.springbootdemo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
// @EnableSwagger2
@EnableWebSecurity
@SpringBootApplication
public class SpringbootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository) throws Exception {
        return (String[] args) -> {
            log.info("start commandline runner");

            var userCnt = userRepository.count();
            if (userCnt > 0) {
                log.warn("skip user init");
                return;
            }

            User user1 = new User("Bob", 10);
            User user2 = new User("Jenny", 25);
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.findAll().forEach(System.out::println);
            log.info("stop commandline runner");
        };
    }
}
