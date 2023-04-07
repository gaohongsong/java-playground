package com.feichai.security.service;

import com.feichai.security.exception.UserNotExistException;
import com.feichai.security.model.Authority;
import com.feichai.security.model.MyUser;
import com.feichai.security.repository.MyUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * 一般的，一个Controller对应一个Service，一个Service对应一个Dao，一个Dao对应一个数据库表，
 * 当然根据项目或业务复杂程度，一个Controller可以调用多个Service，而一个Service 也可以调用多个Dao，
 * 但是Controller层不允许互调，Service层也不允许互调，意思就是AController不能直接调用BController，
 * AService也不能直接去调用BService，遵循高内聚低耦合原则
 */
@Slf4j
@Service("myUserDetailsService")
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        MyUser myUser = myUserRepository.findMyUserByUsername(username);

        if (myUser == null) {
            log.error("用户 {} 不存在!", username);
            throw new UserNotExistException(String.format("用户 %s 不存在", username));
        }

        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (Authority authority : myUser.getMy_authorities()) {
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        // 说明账号存在 {noop} 非加密的使用
        authorities.add(new SimpleGrantedAuthority("ROLE_admin"));
        return new User(
                myUser.getUsername(),
                "{noop}" + myUser.getPassword(),
                true,
                true,
                true,
                true,
                // false,
                authorities
        );
    }
}
