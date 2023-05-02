package com.waffle.repositories.specifications;

import com.waffle.data.entities.User;
import org.springframework.data.jpa.domain.Specification;

import static com.waffle.data.constants.types.user.UserStatus.ACTIVE;

/**
 * Specification class used to set search parameter.
 */
public final class UserSpecification {

    private UserSpecification() {
    }

    /**
     * Search active users.
     *
     * @return {@link Specification<User>}
     */
    public static Specification<User> byActive() {
        return (root, query, criteriaBuilder) ->
              criteriaBuilder.equal(
                      root.join("status"),
                      ACTIVE
              );
    }

    /**
     * Search user by username.
     *
     * @param username username
     * @return {@link Specification<User>}
     */
    public static Specification<User> byUsername(final String username) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(
                    root.join("profile").get("username"),
                    username
            );
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
