package com.waffle.configurations.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Validation properties.
 */
@Component
@Data
@Accessors(fluent = true)
public class ValidationSettings {

    @Value("${waffle.validation.enabled}")
    private boolean enabled;
}
