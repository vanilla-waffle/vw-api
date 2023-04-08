package com.waffle.data.constants.annotations.processors;

import com.waffle.configurations.properties.SecuritySettings;
import com.waffle.data.constants.annotations.validation.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Phone constraint validator.
 */
@Component
@Scope("request")
@RequiredArgsConstructor
public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {
    private static final String PATTERN = "(^$|[0-9]{11})";
    private final SecuritySettings settings;

    @Override
    public void initialize(final Phone constraintAnnotation) {
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        if (!settings.validationEnabled()) {
            return true;
        }

        return value == null || value.matches(PATTERN);
    }
}
