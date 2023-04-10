package org.feichai.system.service.impl;

import org.feichai.system.domain.Role;
import org.feichai.system.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleServiceImplTest {
    @Autowired
    private RoleService roleService;

    @Test
    void findUserRole() {
        List<Role> roles = roleService.findUserRole("admin");
        List<String> roleNames = roles.stream().map(Role::getRoleName).collect(Collectors.toList());
        assertTrue(roleNames.contains("管理员"));
    }
}