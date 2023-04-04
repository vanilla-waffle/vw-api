package com.waffle.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Custom objectmapper injection.
 */
@Configuration
public class SwaggerJacksonConfiguration {

    /**
     * Model resolver bean declaration.
     *
     * @param objectMapper {@link ObjectMapper}
     * @return {@link ModelResolver}
     */
    @Bean
    public ModelResolver modelResolver(final ObjectMapper objectMapper) {
        return new ModelResolver(objectMapper);
    }
}
