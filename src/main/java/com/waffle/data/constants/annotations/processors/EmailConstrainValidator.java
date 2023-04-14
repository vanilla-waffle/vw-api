package com.waffle.data.constants.annotations.processors;

import com.waffle.configurations.properties.ValidationSettings;
import com.waffle.data.constants.annotations.spring.Email;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.AbstractEmailValidator;

import javax.validation.ConstraintValidatorContext;

/**
 * Email constrain validator.
 */
@RequiredArgsConstructor
public class EmailConstrainValidator extends AbstractEmailValidator<Email> {
    private final ValidationSettings settings;

    @Override
    public boolean isValid(final CharSequence value, final ConstraintValidatorContext context) {
        if (!settings.enabled()) {
            return true;
        }

        return super.isValid(value, context);
    }
}
