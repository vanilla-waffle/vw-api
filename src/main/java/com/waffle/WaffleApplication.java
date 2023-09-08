package com.waffle;

import com.waffle.data.constants.annotations.spring.NonDocumented;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class WaffleApplication {

    @NonDocumented
    public static void main(final String[] args) {
        SpringApplication.run(WaffleApplication.class, args);
    }
}
