package com.waffle.configurations.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Cookie security properties.
 */
@Component
@Data
@Accessors(fluent = true)
public class JwtSettings {

    @Value("${waffle.security.jwt.secret}")
    private String secret;
    @Value("${waffle.security.jwt.issuer}")
    private String issuer;
    @Value("${waffle.security.jwt.expiration.basic}")
    private int expireAt;
    @Value("${waffle.security.jwt.expiration.refresh}")
    private int refreshExpireAt;
}
