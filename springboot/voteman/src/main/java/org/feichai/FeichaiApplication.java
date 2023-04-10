package org.feichai;

import org.feichai.common.config.FeichaiProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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

}
