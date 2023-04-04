package com.waffle.repositories;

import com.waffle.data.entities.DriverLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Driver license repository.
 */
public interface DriverLicenseRepository extends JpaRepository<DriverLicense, Long>, JpaSpecificationExecutor<DriverLicense> {
}
