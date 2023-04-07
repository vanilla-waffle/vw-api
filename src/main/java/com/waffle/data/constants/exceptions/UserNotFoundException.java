package com.waffle.data.constants.exceptions;

/**
 * User not found exception.
 */
public class UserNotFoundException extends RuntimeException {
    private static final String MESSAGE = "User does not exist %s";

    /**
     * Exception constructor.
     *
     * @param value {@link Object} any user property
     */
    public UserNotFoundException(final Object value) {
        super(String.format(MESSAGE + ": ", value));
    }

    /**
     * Exception constructor.
     */
    public UserNotFoundException() {
        super(MESSAGE);
    }
}
