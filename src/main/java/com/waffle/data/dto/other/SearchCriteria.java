package com.waffle.data.dto.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Search criteria dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;

    /**
     * Static constructor.
     *
     * @param key entity field
     * @param operation operation
     * @param value value
     * @return SearchCriteria object
     */
    public static SearchCriteria from(final String key, final String operation, final Object value) {
        return new SearchCriteria(key, operation, value);
    }

    /**
     * Static constructor.
     *
     * @param query query
     * @return SearchCriteria object
     */
    public static SearchCriteria from(final String query) {
        if (query == null) {
            return new SearchCriteria();
        }

        final String[] args = query.split("((?=:)|(?<=:))");
        final int n = 3;

        if (args.length < n) {
            return new SearchCriteria();
        }

        return new SearchCriteria(args[0], args[1], args[2]);
    }
}
