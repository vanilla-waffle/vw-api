package com.waffle.data.constants.annotations.processors;

import com.waffle.data.constants.annotations.validation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Phone constraint validator.
 */
public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {
    private static final String PATTERN = "(^$|[0-9]{11})";

    @Override
    public void initialize(final Phone constraintAnnotation) {
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        return value == null || value.matches(PATTERN);
    }
}
