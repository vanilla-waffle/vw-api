package com.waffle.services.utils;

import com.waffle.data.constants.annotations.spring.NonDocumented;
import com.waffle.data.constants.annotations.spring.Utils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

@Utils
public final class Urls {

    private Urls() {
    }

    @NonDocumented
    public static String current() {
        final UriComponents uri = buildUriComponents();
        return uri.getHost() + uri.getPath();
    }

    @NonDocumented
    public static String host() {
        return "http://" + buildUriComponents().getHost();
    }

    @NonDocumented
    public static int port() {
        return buildUriComponents().getPort();
    }

    private static UriComponents buildUriComponents() {
        return ServletUriComponentsBuilder.fromCurrentRequestUri().build();
    }
}
