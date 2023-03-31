package com.waffle.repositories;

import com.waffle.data.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Location repository.
 */
public interface LocationRepository extends JpaRepository<Location, Long>, JpaSpecificationExecutor<Location> {
}
