package com.onyx.springbootdemo.dao;

import com.onyx.springbootdemo.pojo.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByUsername(String username);
}
