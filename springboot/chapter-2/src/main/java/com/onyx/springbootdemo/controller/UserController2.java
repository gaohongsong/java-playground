package com.onyx.springbootdemo.controller;

import com.onyx.springbootdemo.dao.UserRepository;
import com.onyx.springbootdemo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "User Service", tags = {"用户模块2"})
@RestController
@RequestMapping("/demo")
public class UserController2 {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    @ApiOperation("save")
    public ResponseEntity<String> saveUser(@Valid @RequestBody User user) {
        // https://www.geeksforgeeks.org/spring-boot-validation-using-hibernate-validator/
        userRepository.save(user);
        return ResponseEntity.ok("created");
    }

    @PostMapping("/add")
    @ApiOperation("add")
    public String addNewUser(@RequestParam String username, @RequestParam int age) {
        User u = new User();
        u.setUsername(username);
        u.setAge(age);
        u.setPassword("default");
        userRepository.save(u);

        return "Saved";
    }

    @GetMapping("/all")
    @ApiOperation("all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/filter")
    @ApiOperation("filter")
    public User filterUsers(@RequestParam String username) {
        return userRepository.findByUsername(username);
    }
}
