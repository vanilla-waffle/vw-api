package com.waffle.data.constants.exceptions;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationFailedException extends AuthenticationException {

    public AuthenticationFailedException(final String msg) {
        super(msg);
    }
}
