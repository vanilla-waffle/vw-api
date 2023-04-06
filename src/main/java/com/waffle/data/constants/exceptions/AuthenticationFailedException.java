package com.waffle.data.constants.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Authentication failed exception.
 */
public class AuthenticationFailedException extends AuthenticationException {

    /**
     * Constructor.
     *
     * @param msg {@link String}
     */
    public AuthenticationFailedException(final String msg) {
        super(msg);
    }
}
