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
public class CookieSettings {

    @Value("${waffle.security.cookie.secret}")
    private String secret;
    @Value("${waffle.security.cookie.issuer}")
    private String issuer;
    @Value("${waffle.security.cookie.expires-after}")
    private int expiresAfter;
    @Value("${waffle.security.cookie.always-remember}")
    private boolean alwaysRemember;
}
