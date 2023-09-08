package com.waffle.configurations.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Security properties.
 */
@Component
@Getter
@Setter
@Accessors(fluent = true)
public class SecuritySettings {

    @Value("${waffle.security.encoder-strength}")
    private int encoderStrength;
}
