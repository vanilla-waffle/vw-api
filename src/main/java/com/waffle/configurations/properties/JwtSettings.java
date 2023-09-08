package com.waffle.configurations.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * JWT properties.
 */
@Component
@Getter
@Setter
@Accessors(fluent = true)
public class JwtSettings {

    @Value("${waffle.security.jwt.secret}")
    private String secret;
    @Value("${waffle.security.jwt.issuer}")
    private String issuer;
    @Value("${waffle.security.jwt.expiration.access}")
    private int accessExpiresAt;
    @Value("${waffle.security.jwt.expiration.refresh}")
    private int refreshExpiresAt;
}
