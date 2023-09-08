package com.waffle.services.utils;

import com.google.common.base.CaseFormat;

/**
 * Case formatters.
 */
public final class CaseFormats {

    private CaseFormats() {
    }

    /**
     * Convert string from snake case to camel case.
     *
     * @param snakeCase {@link String}
     * @return {@link String}
     */
    public static String snakeToCamel(final String snakeCase) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, snakeCase);
    }
}
