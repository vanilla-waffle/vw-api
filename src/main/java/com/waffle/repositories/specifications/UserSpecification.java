package com.waffle.repositories.specifications;

import com.waffle.data.dto.other.SearchCriteria;
import com.waffle.data.entity.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import static com.waffle.data.constants.types.other.Operation.*;

/**
 * Specification class used to set search parameter.
 */
public final class UserSpecification {

    /**
     * Search by pre-defined criteria of key, operation and value.
     *
     * @param criteria search criteria
     * @return search parameter
     */
    public static Specification<User> by(final SearchCriteria criteria) {
        return (root, query, builder) -> {
            Path<Object> path = getPath(root, criteria);

            switch (criteria.getOperation()) {
                case LIKE:
                    if (criteria.getKey().contains(".")) {
                        String[] parts = criteria.getKey().split("\\.");
                        return builder.like(
                                root.get(parts[0]).get(parts[1]), "%" + criteria.getValue() + "%"
                        );
                    }

                    return builder.like(
                            root.get(criteria.getKey()), "%" + criteria.getValue() + "%"
                    );
                case EQUAL:
                    return builder.equal(
                            path, criteria.getValue()
                    );
                default:
                    return null;
            }
        };
    }

    private static Path<Object> getPath(final Root<User> root, final SearchCriteria criteria) {
        Path<Object> path;

        if (criteria.getKey().contains(".")) {
            String[] split = criteria.getKey().split("\\.");
            int keyPosition = 0;
            path = root.get(split[keyPosition]);

            for (String criteriaKeys : split) {
                if (keyPosition > 0) {
                    path = path.get(criteriaKeys);
                }
                keyPosition++;
            }
        } else {
            path = root.get(criteria.getKey());
        }

        return path;
    }

    /**
     * Search user by ID.
     *
     * @param id user id
     * @return search parameter
     */
    public static Specification<User> byId(final long id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("id"),
                        id
                );
    }

    /**
     * Search user by email.
     *
     * @param email user email
     * @return search parameter
     */
    public static Specification<User> byEmail(final String email) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(
                    root.get("profile").get("email"),
                    email
            );
    }
}
