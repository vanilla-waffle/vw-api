package com.waffle.data.constants.annotations.validation.processors;

import com.waffle.configurations.properties.ValidationSettings;
import com.waffle.data.constants.annotations.spring.NonDocumented;
import com.waffle.data.constants.annotations.validation.Phone;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@NonDocumented
@RequiredArgsConstructor
public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {
    private static final String PATTERN = "(^$|[0-9]{11})";
    private final ValidationSettings settings;

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        if (!settings.enabled()) {
            return true;
        }

        return value == null || value.matches(PATTERN);
    }
}
