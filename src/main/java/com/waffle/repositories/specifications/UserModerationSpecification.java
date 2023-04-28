package com.waffle.repositories.specifications;

import com.waffle.data.entities.admin.UserModeration;
import org.springframework.data.jpa.domain.Specification;

/**
 * User moderation specification.
 */
public final class UserModerationSpecification {

    private UserModerationSpecification() {
    }

    /**
     * Search by license.
     *
     * @param id {@link Long}
     * @return {@link Specification<UserModeration>}
     */
    public static Specification<UserModeration> byLicense(final Long id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.join("license").get("id"),
                        id
                );
    }

    /**
     * Search by user.
     *
     * @param id {@link Long}
     * @return {@link Specification<UserModeration>}
     */
    public static Specification<UserModeration> byUser(final Long id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.join("user").get("id"),
                        id
                );
    }
}
