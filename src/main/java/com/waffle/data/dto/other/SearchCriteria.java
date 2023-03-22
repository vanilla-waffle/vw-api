package com.waffle.data.dto.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Search criteria.
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

        final String[] args = query.split("((?=\\$|:)|(?<=\\$|:))");
        final int n = 3;

        if (args.length < n) {
            return new SearchCriteria();
        }

        return new SearchCriteria(args[0], args[1], args[2]);
    }

    /**
     * Checks if provided criteria key is nested (ex: fieldA.fieldB).
     *
     * @return result of check.
     */
    public boolean isNested() {
        final List<String> keys = this.getNestedKeysAsList();

        if (keys == null) {
            return false;
        }

        return keys.size() > 1;
    }

    /**
     * Convert key to list of keys if it is nested.
     *
     * @return list of strings
     */
    public List<String> getNestedKeysAsList() {
        return this.key.contains(".") ? List.of(this.key.split("\\.")) : null;
    }
}
