package com.waffle.repositories.specifications;

import com.waffle.data.entities.User;
import com.waffle.data.entities.admin.UserModeration;
import org.springframework.data.jpa.domain.Specification;

import static com.waffle.data.constants.types.admin.ModerationStatus.ON_REVIEW;

/**
 * User moderation specification.
 */
public final class UserModerationSpecification {

    private UserModerationSpecification() {
    }

    /**
     * Search active moderation requests.
     *
     * @return {@link Specification<UserModeration>}
     */
    public static Specification<User> byActive() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.join("status"),
                        ON_REVIEW
                );
    }

    /**
     * Search by license.
     *
     * @param licenseNumber {@link String}
     * @return {@link Specification<UserModeration>}
     */
    public static Specification<UserModeration> byLicenseNumber(final String licenseNumber) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.join("license").get("licenseNumber"),
                        licenseNumber
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

    /**
     * Search by pending request status.
     *
     * @return {@link Specification<UserModeration>}
     */
    public static Specification<UserModeration> hasPending() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("status"),
                        ON_REVIEW
                );
    }
}
