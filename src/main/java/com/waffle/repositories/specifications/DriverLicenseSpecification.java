package com.waffle.repositories.specifications;

import com.waffle.data.entities.DriverLicense;
import org.springframework.data.jpa.domain.Specification;

/**
 * Driver license specification.
 */
public final class DriverLicenseSpecification {

    private DriverLicenseSpecification() {
    }

    /**
     * Search by user.
     *
     * @param number {@link Long}
     * @return {@link Specification <DriverLicense>}
     */
    public static Specification<DriverLicense> byLicenseNumber(final String number) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("licenseNumber"),
                        number
                );
    }
}
