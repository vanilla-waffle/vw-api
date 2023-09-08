package com.waffle.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfiguration {
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * Customized object mapper bean.
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

        final LocalDateSerializer ldSerializer = new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_PATTERN));
        final LocalDateDeserializer ldDeserializer = new LocalDateDeserializer(DateTimeFormatter.ofPattern(DATE_PATTERN));

        final LocalDateTimeDeserializer ldtDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        final LocalDateTimeSerializer ldtSerializer = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));

        module.addSerializer(ldtSerializer);
        module.addSerializer(ldSerializer);
        module.addDeserializer(LocalDateTime.class, ldtDeserializer);
        module.addDeserializer(LocalDate.class, ldDeserializer);

        return module;
    }
}
