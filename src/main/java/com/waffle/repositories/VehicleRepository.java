package com.waffle.repositories;

import com.waffle.data.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Post repository.
 */
@Repository
public interface VehicleRepository extends
        FilteredJpaRepository<Vehicle, Long>,
        JpaSpecificationExecutor<Vehicle> {
}
