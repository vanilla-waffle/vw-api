package com.waffle.services.entity;

import com.waffle.data.entities.DriverLicense;
import com.waffle.services.common.BasicService;
import org.springframework.data.jpa.domain.Specification;

/**
 * Driver license service.
 */
public interface DriverLicenseService extends BasicService<DriverLicense> {

    /**
     * Exists by.
     *
     * @param by {@link Specification<DriverLicense>}
     * @return {@code boolean}
     */
    boolean exists(Specification<DriverLicense> by);
}
