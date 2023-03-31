package com.waffle.repositories.specifications;

import com.waffle.data.entity.Vehicle;
import org.springframework.data.jpa.domain.Specification;

/**
 * Specification class used to set search parameter.
 */
public final class VehicleSpecification {

    private VehicleSpecification() {
    }

    /**
     * Search post by author ID.
     *
     * @param id author id
     * @return search parameter
     */
    public static Specification<Vehicle> byUser(final Long id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.join("user").get("id"),
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
