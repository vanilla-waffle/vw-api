package com.waffle.data.constants.annotations.validation;

import com.waffle.configurations.validations.PhoneConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates phone number that should contain 11 digits.
 */
@Documented
@Constraint(validatedBy = PhoneConstraintValidator.class)
@Target({ FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface Phone {

    /**
     * Error message.
     *
     * @return message
     */
    String message() default "Invalid phone number";

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
