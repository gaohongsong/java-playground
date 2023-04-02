package com.onyx.springbootdemo.controller;

import com.onyx.springbootdemo.dao.UserRepository;
import com.onyx.springbootdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/demo")
public class UserController2 {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok("created");
    }

    @PostMapping("/add")
    public String addNewUser(@RequestParam String username, @RequestParam int age) {
        User u = new User();
        u.setUsername(username);
        u.setAge(age);
        u.setPassword("default");
        userRepository.save(u);

        return "Saved";
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/filter")
    public Iterable<User> filterUsers(@RequestParam String username) {
        return userRepository.findByUsername(username);
    }
}
