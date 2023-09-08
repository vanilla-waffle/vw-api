package com.waffle.services.entity;

import com.waffle.data.entities.City;
import com.waffle.services.common.ReadonlyService;

/**
 * City service.
 */
public interface CityService extends ReadonlyService<City, Long> {

    /**
     * Find one.
     *
     * @param name {@link String}
     * @return {@link City}
     */
    City find(String name);
}
