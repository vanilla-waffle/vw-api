package com.waffle.data.constants.annotations.spring;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * Generic meta-annotation that goes as a shortcut for controller initializing.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
@ResponseBody
@RequestMapping
@Validated
public @interface Api {

    /**
     * Controller base path.
     *
     * @return value
     */
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] value() default {};
}
