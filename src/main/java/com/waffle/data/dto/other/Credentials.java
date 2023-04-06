package com.waffle.data.dto.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.Authentication;

/**
 * Basic user credentials dto.
 */
@Data
@AllArgsConstructor
public class Credentials {

    private String username;
    private String password;

    /**
     * Static constructor.
     *
     * @param authentication {@link Authentication}
     * @return {@link Credentials}
     */
    public static Credentials from(final Authentication authentication) {
        return new Credentials((String) authentication.getPrincipal(), (String) authentication.getCredentials());
    }
}
