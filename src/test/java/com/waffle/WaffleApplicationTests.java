package com.waffle;

import com.waffle.dto.request.UserCreateDto;
import com.waffle.services.impl.UserServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Disabled;
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
    @Disabled
    void test() {
        final UserCreateDto user = generator.nextObject(UserCreateDto.class);
        service.save(user);
    }
}
