package com.waffle.repositories;

import com.waffle.data.entities.admin.VehicleModeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Vehicle moderation repository.
 */
@Repository
public interface VehicleModerationRepository extends JpaRepository<VehicleModeration, Long> {
}
