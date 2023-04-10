package org.feichai.system.service.impl;

import org.feichai.system.domain.User;
import org.feichai.system.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;
    @Test
    void findByName() {
        User user = userService.findByName("admin");
        assertEquals(user.getUsername(), "admin");
    }
}