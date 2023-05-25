package com.waffle.data.repositories;

import com.waffle.data.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends
        FilteredJpaRepository<Vehicle, Long>,
        JpaSpecificationExecutor<Vehicle> {
}
