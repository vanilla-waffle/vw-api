package com.waffle.data.constants.annotations.processors;

import com.waffle.configurations.properties.SecuritySettings;
import com.waffle.data.constants.annotations.spring.Email;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.AbstractEmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.ConstraintValidatorContext;

/**
 * Email constrain validator.
 */
@Component
@RequestScope
@RequiredArgsConstructor
public class EmailConstrainValidator extends AbstractEmailValidator<Email> {
    private final SecuritySettings settings;

    @Override
    public boolean isValid(final CharSequence value, final ConstraintValidatorContext context) {
        if (!settings.validationEnabled()) {
            return true;
        }

        return super.isValid(value, context);
    }
}
