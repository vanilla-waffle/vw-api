package com.waffle.data.constants.annotations.spring;

import java.lang.annotation.*;

/**
 * Indicates that method/class is not documented.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NonDocumented {
}
