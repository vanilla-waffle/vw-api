package com.waffle.data.constants.annotations.spring;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

/**
 * Security annotation that gets the current authorized user.
 */
@Target({ ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@NonDocumented
@AuthenticationPrincipal
@Parameter(hidden = true)
public @interface Principal {
}
