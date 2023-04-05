package com.waffle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class WaffleApplication {

    /**
     * Main method.
     *
     * @param args arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(WaffleApplication.class, args);
    }
}
