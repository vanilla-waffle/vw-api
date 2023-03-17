package com.waffle.repositories.specifications;

import com.waffle.data.entity.User;
import org.springframework.data.jpa.domain.Specification;

/**
 * Specification class used to set search parameter.
 */
public final class UserSpecification {

    private UserSpecification() {

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
