package com.waffle.services.utils;

import com.waffle.data.constants.annotations.spring.Utils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

@Utils
public final class Urls {

    private Urls() {
    }

    /**
     * Get host name.
     *
     * @return {@link String}
     */
    public static String host() {
        return "http://" + buildUriComponents().getHost();
    }

    /**
     * Get port.
     *
     * @return {@code int}
     */
    public static int port() {
        return buildUriComponents().getPort();
    }

    private static UriComponents buildUriComponents() {
        return ServletUriComponentsBuilder.fromCurrentRequestUri().build();
    }
}
