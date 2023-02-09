package com.waffle;

import com.waffle.dto.UserDto;
import com.waffle.services.impl.UserServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WaffleApplicationTests {
    private final EasyRandom generator = new EasyRandom();

    @Autowired
    private UserServiceImpl service;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        final UserDto.Request.Create user = generator.nextObject(UserDto.Request.Create.class);
        service.save(user);
    }
}
