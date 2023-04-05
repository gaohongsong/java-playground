package org.feichai.themyleaf;

import org.feichai.themyleaf.model.Result;
import org.feichai.themyleaf.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

@SpringBootTest(classes = {ThemyleafApplication.class})
public class RedisTests {
    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisObjectTemplate;
    // @Autowired
    // private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void testString() {
        stringRedisTemplate.opsForValue().set("name", "feichai");
        String value = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name = " + value);
        Assertions.assertEquals("feichai", value);
    }

    @Test
    public void testJsonSerializable() {
        Result<Object> result = new Result<>();
        result.setData(100);
        result.setMessage("success");
        result.setCode(0);
        redisObjectTemplate.opsForValue().set("result", result);
        Assertions.assertEquals(result, (Result)redisObjectTemplate.opsForValue().get("result"));
    }

    // @Test
    // public void testSerializable() {
    //     User user = new User();
    //     user.setAge(10);
    //     user.setName("pitou");
    //
    //     redisTemplate.opsForValue().set("result", user);
    //     Assertions.assertEquals(user, (User)redisTemplate.opsForValue().get("result"));
    // }
}
