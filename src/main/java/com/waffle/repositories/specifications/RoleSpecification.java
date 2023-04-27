package com.waffle.repositories.specifications;

import com.waffle.data.constants.types.user.RoleType;
import com.waffle.data.entities.Role;
import org.springframework.data.jpa.domain.Specification;

/**
 * Role specification.
 */
public final class RoleSpecification {

    private RoleSpecification() {
    }

    /**
     * Search by role name.
     *
     * @param type {@link RoleType}
     * @return {@link Specification<Role>}
     */
    public static Specification<Role> byRoleType(final RoleType type) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("role"),
                        type
                );
    }
}
