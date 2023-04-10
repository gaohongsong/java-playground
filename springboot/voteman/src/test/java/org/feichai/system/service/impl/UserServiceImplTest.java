package org.feichai.system.service.impl;

import org.feichai.system.domain.User;
import org.feichai.system.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    void findByName() {
        User user = userService.findByName("admin");
        assertEquals(user.getUsername(), "admin");
    }
}