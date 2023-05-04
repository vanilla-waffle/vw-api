package com.waffle.services.utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Filter utility class.
 */
public final class Filters {

    private Filters() {
    }

    /**
     * Transform parameters to {@link Map} from given {@link List}.
     *
     * @param filters {@link List<String>}
     * @return {@link Map}
     */
    public static Map<String, String> toMap(final List<String> filters) {
        if (filters == null) {
            return Collections.emptyMap();
        }

        return filters.stream()
                .map(f -> f.split(":"))
                .collect(HashMap::new, (m, arr) -> m.put(arr[0], arr[1]), Map::putAll);
    }

    /**
     * Convert {@link Map} parameters to an array of {@link Predicate}.
     *
     * @param params {@link Map}
     * @param cb {@link CriteriaBuilder}
     * @param root {@link Root}
     * @return {@code Predicate[]}
     */
    public static Predicate[] toPredicates(final Map<String, String> params, final CriteriaBuilder cb, final Root<?> root) {
        return params.entrySet()
                .stream()
                .map((entry) -> cb.equal(cb.lower(root.get(entry.getKey())), entry.getValue().toLowerCase()))
                .toArray(Predicate[]::new);
    }
}
