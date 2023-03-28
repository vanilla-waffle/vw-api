package com.waffle.repositories.specifications;

import com.waffle.data.dto.other.SearchCriteria;
import com.waffle.data.entity.Vehicle;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static com.waffle.data.constants.types.other.Operation.EQUAL;
import static com.waffle.data.constants.types.other.Operation.LIKE;
import static com.waffle.data.utils.EnumUtils.toEnum;

/**
 * Specification class used to set search parameter.
 */
public final class PostSpecification {

    private PostSpecification() {

    }

    /**
     * Search by pre-defined criteria of key, operation and value.
     *
     * @param criteria search criteria
     * @return search parameter
     */
    public static Specification<Vehicle> by(final SearchCriteria criteria) {
        return (root, query, builder) -> {
            final String key = criteria.getKey();
            Object value = criteria.getValue();

            switch (criteria.getOperation()) {
                case LIKE:
                    if (criteria.isNested()) {
                        final List<String> keys = List.of(criteria.getKey().split("\\."));
                        return builder.like(
                                root.join(keys.get(0)).get(keys.get(1)), "%" + value + "%"
                        );
                    }

                    return builder.like(
                            root.get(key), "%" + value + "%"
                    );
                case EQUAL:
                    final Enum<?> em = toEnum(value.toString());

                    if (em != null) {
                        value = em;
                    }

                    if (criteria.isNested()) {
                        final List<String> keys = List.of(criteria.getKey().split("\\."));
                        return builder.equal(
                                root.join(keys.get(0)).get(keys.get(1)), value
                        );
                    }

                    return builder.equal(
                            root.get(key), value
                    );
                default:
                    return null;
            }
        };
    }

    /**
     * Search post by author ID.
     *
     * @param id author id
     * @return search parameter
     */
    public static Specification<Vehicle> byAuthor(final Long id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("profile").get("id"),
                        id
                );
    }

    /**
     * Search post by title.
     *
     * @param title post title
     * @return search parameter
     */
    public static Specification<Vehicle> byTitle(final String title) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("title"),
                        title
                );
    }
}
