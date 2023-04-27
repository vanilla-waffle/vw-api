package com.waffle.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Jackson's configuration.
 */
@Configuration
public class JacksonConfiguration {
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";

    /**
     * Customized objectmapper bean.
     *
     * @return {@link ObjectMapper}
     */
    @Bean
    public ObjectMapper objectMapper() {
        return JsonMapper.builder()
                .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .addModule(javaTimeModule())
                .build();
    }

    private JavaTimeModule javaTimeModule() {
        final JavaTimeModule module = new JavaTimeModule();
        final LocalDateTimeDeserializer deserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        final LocalDateTimeSerializer serializer = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));

        module.addDeserializer(LocalDateTime.class, deserializer);
        module.addSerializer(serializer);

        return module;
    }
}
