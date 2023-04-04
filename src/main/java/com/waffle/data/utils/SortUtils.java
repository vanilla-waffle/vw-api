package com.waffle.data.utils;

import org.springframework.data.domain.Sort;

/**
 * Sort utils.
 */
public final class SortUtils {

    private SortUtils() {
    }

    /**
     * Builds {@link Sort} instance.
     *
     * @param query {@link String} sort query
     * @return {@link Sort}
     */
    public static Sort from(final String query) {
        final String[] args = query.split(" ");

        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid sort query was provided: " + query);
        }

        final String by = args[0];
        final Sort.Direction dir = Sort.Direction.fromString(args[1]);
        return Sort.by(dir, by);
    }
}
