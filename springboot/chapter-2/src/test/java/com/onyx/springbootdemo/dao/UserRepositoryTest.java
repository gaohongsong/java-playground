package com.onyx.springbootdemo.dao;

import com.onyx.springbootdemo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void userRepositoryTest() {
        try {
            User user = new User("lisi", 100);
            userRepository.save(user);
        } catch (Exception ex) {
            System.out.println("ignore exist lisi user");
        }
        User item = userRepository.findByUsername("lisi");
        System.out.println(item);
        Assert.assertNotNull(item);

        assertTrue(userRepository.existsById(1L));
        Optional<User> byId = userRepository.findById(1L);
        assertTrue(byId.isPresent());

        userRepository.deleteById(1L);
        assertFalse(userRepository.existsById(1L));
    }
}