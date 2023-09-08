package com.waffle.data.repositories;

import com.waffle.data.entities.admin.VehicleModeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleModerationRepository extends JpaRepository<VehicleModeration, Long> {
}
