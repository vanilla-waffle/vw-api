package com.waffle.configurations.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Security properties.
 */
@Component
@Data
@Accessors(fluent = true)
public class SecuritySettings {

    @Value("${waffle.security.cors-enabled}")
    private boolean corsEnabled;
    @Value("${waffle.security.encoder-strength}")
    private int encoderStrength;
}
