package com.waffle.data.constants.annotations.processors;

import com.waffle.configurations.properties.SecuritySettings;
import com.waffle.data.constants.annotations.validation.Password;
import lombok.RequiredArgsConstructor;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * Password constraint validator.
 */
@RequiredArgsConstructor
public class PasswordConstraintValidator implements ConstraintValidator<Password, String> {
    private final SecuritySettings settings;
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 30;

    @Override
    public void initialize(final Password arg0) {
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        if (!settings.validationEnabled()) {
            return true;
        }

        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(MIN_LENGTH, MAX_LENGTH),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new WhitespaceRule()
        ));

        RuleResult result = validator.validate(new PasswordData(value));

        if (result.isValid()) {
            return true;
        }

        List<String> messages = validator.getMessages(result);
        String messageTemplate = String.join(",", messages);

        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
