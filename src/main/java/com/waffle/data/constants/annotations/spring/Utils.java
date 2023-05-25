package com.waffle.data.constants.annotations.spring;

import java.lang.annotation.*;

/**
 * Indicates an utility class.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Utils {
}
