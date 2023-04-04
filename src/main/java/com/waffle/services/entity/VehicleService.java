package com.waffle.services.entity;


import com.waffle.data.entities.Vehicle;
import com.waffle.services.common.BasicService;
import com.waffle.services.common.SortingService;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Post service.
 */
public interface VehicleService extends BasicService<Vehicle>, SortingService<Vehicle> {

    /**
     * Find all {@link Vehicle}.
     *
     * @param sort {@link Sort} sort query
     * @param userId {@link Long} user id
     * @return {@link List<Vehicle>}
     */
    List<Vehicle> findAll(Sort sort, Long userId);

    /**
     * Find all {@link Vehicle}.
     *
     * @param userId {@link Long} user id
     * @return {@link List<Vehicle>}
     */
    List<Vehicle> findAll(Long userId);
}
