package org.feichai;

import lombok.extern.slf4j.Slf4j;
import org.feichai.common.config.FeichaiProperties;
import org.feichai.system.domain.User;
import org.feichai.system.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@MapperScan({"org.feichai.*.dao"})
@EnableConfigurationProperties(FeichaiProperties.class)
@EnableCaching
@EnableAsync
public class FeichaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeichaiApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserService userService) throws Exception {
        return (String[] args) -> {
            log.info("start commandline runner");
            User user = userService.findByName("admin");
            System.out.println(user.getUsername());
        };
    }
}
