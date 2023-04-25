package com.waffle.data.constants.exceptions;

/**
 * User not found exception.
 */
public class NotFoundException extends RuntimeException {

    /**
     * Exception constructor.
     *
     * @param message {@link String}
     */
    public NotFoundException(final String message) {
        super(message);
    }
}
