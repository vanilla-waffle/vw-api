package com.waffle.data.constants.exceptions;

/**
 * Vehicle not found exception.
 */
public class VehicleNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Vehicle does not exist: %s";

    /**
     * Exception constructor.
     *
     * @param value {@link Object} any vehicle property.
     */
    public VehicleNotFoundException(final Object value) {
        super(String.format(MESSAGE, value));
    }
}
