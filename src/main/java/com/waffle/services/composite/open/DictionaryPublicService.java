package com.waffle.services.composite.open;

import com.waffle.data.entities.City;

import java.util.List;

/**
 * Dictionary public service.
 */
public interface DictionaryPublicService {

    /**
     * Find all cities.
     *
     * @return {@link List} of {@link City}
     */
    List<City> findAllCities();
}
