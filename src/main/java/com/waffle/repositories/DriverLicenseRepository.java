package com.waffle.repositories;

import com.waffle.data.entity.DriverLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Driver license repository.
 */
public interface DriverLicenseRepository extends JpaRepository<DriverLicense, Long>, JpaSpecificationExecutor<DriverLicense> {
}
