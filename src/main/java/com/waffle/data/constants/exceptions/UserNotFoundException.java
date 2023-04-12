package com.waffle.data.constants.exceptions;

/**
 * User not found exception.
 */
public class UserNotFoundException extends RuntimeException {

    /**
     * Exception constructor.
     *
     * @param value {@link Object} any user property
     */
    public UserNotFoundException(final String value) {
        super(String.format("User does not exist: %s", value));
    }

    /**
     * Exception constructor.
     *
     * @param value {@link Object} any user property
     */
    public UserNotFoundException(final Long value) {
        super(String.format("User does not exist %d", value));
    }

    /**
     * Exception constructor.
     */
    public UserNotFoundException() {
        super("User does not exist");
    }
}
