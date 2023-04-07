package com.feichai.security.repository;

import com.feichai.security.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
    // MyUser findByUsername(String username);
    MyUser findMyUserByUsername(String username);
}