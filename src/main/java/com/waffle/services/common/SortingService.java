package com.waffle.services.common;

import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Generic service of common methods with sorting abilities.
 *
 * @param <T> any valid entity that has corresponding repository
 */
public interface SortingService<T> {

    /**
     * Find all entities sorted.
     *
     * @param sort {@link Sort} sort params
     * @return list of entities.
     */
    List<T> findAll(Sort sort);
}
