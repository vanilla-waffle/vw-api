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
     * Search user by username.
     *
     * @param username username
     * @return {@link Specification<User>}
     */
    public static Specification<User> byUsername(final String username) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(
                    root.join("profile").get("username"),
                    username
            );
        };
    }

    /**
     * Search user by email.
     *
     * @param email user email
     * @return {@link Specification<User>}
     */
    public static Specification<User> byEmail(final String email) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(
                    root.get("profile").get("email"),
                    email
            );
    }
}
