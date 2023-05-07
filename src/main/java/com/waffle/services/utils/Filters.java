package com.waffle.services.utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

import static java.util.Arrays.asList;

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
                .map((entry) -> toPredicate(entry.getKey(), entry.getValue(), cb, root))
                .toArray(Predicate[]::new);
    }

    private static Predicate toPredicate(final String key, final String val, final CriteriaBuilder cb, final Root<?> root) {
        final List<String> segments = asList(key.split("\\."));

        if (segments.size() < 2) {
            return cb.like(cb.lower(root.get(segments.get(0))), "%" + val.toLowerCase() + "%");
        }

        Path<String> path = null;

        for (String segment : segments) {
            path = join(root, path, segment);
        }

        return cb.like(cb.lower(path), "%" + val.toLowerCase() + "%");
    }

    private static Path<String> join(final Root<?> root, final Path<String> path, final String key) {
        try {
            return root.join(key);
        } catch (IllegalArgumentException e) {
            return path.get(key);
        }
    }
}
