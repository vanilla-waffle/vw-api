package com.waffle.services.utils;

import org.springframework.data.domain.Sort;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;

/**
 * Sort utils.
 */
public final class Sorts {

    private Sorts() {
    }

    /**
     * Builds {@link Sort} instance.
     *
     * @param query {@link String} sort query
     * @return {@link Sort}
     */
    public static Sort of(final String query) {
        final String[] args = query.split(" ");

        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid sort query was provided: " + query);
        }

        final String by = LOWER_UNDERSCORE.to(LOWER_CAMEL, args[0]);
        final Sort.Direction dir = Sort.Direction.fromString(args[1]);
        return Sort.by(dir, by);
    }
}
