package com.waffle.data.constants.exceptions;

/**
 * User already exists exception.
 */
public class UserAlreadyExistsException extends RuntimeException {
    private static final String MESSAGE = "User with provided property already exists: %s";

    /**
     * Exception constructor.
     *
     * @param value {@link String} user email
     */
    public UserAlreadyExistsException(final String value) {
        super(String.format(MESSAGE, value));
    }
}
