package com.waffle.data.constants.annotations.spring;

import com.waffle.data.constants.annotations.validation.processors.EmailConstrainValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Email validation annotation.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Constraint(validatedBy = { EmailConstrainValidator.class })
@Documented
@Retention(RUNTIME)
public @interface Email {

    /**
     * Message.
     *
     * @return {@link String}
     */
    String message() default "Invalid email was provided";

    /**
     * Groups.
     *
     * @return {@link Class}
     */
    Class<?>[] groups() default {};

    /**
     * Payload.
     *
     * @return {@link Class}
     */
    Class<? extends Payload>[] payload() default {};
}
