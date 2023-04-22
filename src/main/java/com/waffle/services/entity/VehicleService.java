package com.waffle.services.entity;


import com.waffle.data.entities.Vehicle;
import com.waffle.services.common.BasicService;
import com.waffle.services.common.PagingService;
import com.waffle.services.common.SortingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Post service.
 */
public interface VehicleService extends
        BasicService<Vehicle>,
        SortingService<Vehicle>,
        PagingService<Vehicle> {

    /**
     * Find all.
     *
     * @param userId {@link Long} user id
     * @return {@link List<Vehicle>}
     */
    List<Vehicle> findAll(Long userId);

    /**
     * Find all.
     *
     * @param sort {@link Sort} sort query
     * @param userId {@link Long} user id
     * @return {@link List<Vehicle>}
     */
    List<Vehicle> findAll(Sort sort, Long userId);

    /**
     * Find all.
     *
     * @param sort   {@link Sort}
     * @param userId {@link Long}
     * @param page   {@link PageRequest}
     * @return {@link List<Vehicle>}
     */
    Page<Vehicle> findAll(Sort sort, Long userId, PageRequest page);
}
