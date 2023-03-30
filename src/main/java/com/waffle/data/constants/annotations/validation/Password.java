package com.waffle.data.constants.annotations.validation;

import com.waffle.configurations.validations.PasswordConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Password field-level annotation.
 */
@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface Password {

    /**
     * Error message.
     *
     * @return message
     */
    String message() default "Invalid password";

    /**
     * Message groups.
     *
     * @return group of classes
     */
    Class<?>[] groups() default {};

    /**
     * Payload.
     *
     * @return payload class
     */
    Class<? extends Payload>[] payload() default {};
}
