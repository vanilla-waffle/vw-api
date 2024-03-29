package com.waffle.data.repositories;

import com.waffle.data.entities.DriverLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverLicenseRepository extends JpaRepository<DriverLicense, Long>, JpaSpecificationExecutor<DriverLicense> {
}
