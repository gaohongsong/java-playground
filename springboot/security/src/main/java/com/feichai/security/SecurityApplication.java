package com.feichai.security;

import com.feichai.security.model.Authority;
import com.feichai.security.model.MyUser;
import com.feichai.security.repository.AuthorityRepository;
import com.feichai.security.repository.MyUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@EnableWebSecurity
@SpringBootApplication
public class SecurityApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(MyUserRepository myUserRepository, AuthorityRepository authorityRepository) throws Exception {
        return (String[] args) -> {
            log.info("start commandline runner");
            if (myUserRepository.count() > 0) {
                log.info("skip init admin users");
                return;
            }

            // 创建角色
            ArrayList<Authority> authorities = new ArrayList<>();
            for (String role : new String[]{
                    "admin",
                    "teacher"
            }) {
                authorities.add(new Authority("ROLE_" + role));
            }

            // List to Set
            // Caused by: org.springframework.dao.InvalidDataAccessApiUsageException: detached entity passed to persist: com.feichai.security.model.Authority;
            // nested exception is org.hibernate.PersistentObjectException: detached entity passed to persist: com.feichai.security.model.Authority
            // Set<Authority> savedAuthorities = new HashSet<>(authorityRepository.saveAll(authorities));
            authorityRepository.saveAll(authorities);

            String encrypedPassword = passwordEncoder.encode("admin");
            MyUser admin = new MyUser("admin", encrypedPassword);
            myUserRepository.save(admin);

            // List<Authority> savedAuthorities = authorityRepository.findAll();
            // for (Authority authority : savedAuthorities) {
            //     System.out.println(authority.getId());
            //     authority.getUsers().add(admin);
            //     admin.getMy_authorities().add(authority);
            //
            //     authorityRepository.save(authority);
            //     myUserRepository.save(admin);
            // }

            // admin.setMy_authorities(savedAuthorities);
            // myUserRepository.save(admin);
        };
    }
}