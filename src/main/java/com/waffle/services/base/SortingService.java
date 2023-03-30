package com.waffle.services.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
     * @param sort sort parameters
     * @return list of entities.
     */
    List<T> findAll(Sort sort);

    /**
     * Find all entities sorted with pagination.
     *
     * @param sort sort parameters
     * @param page pagination parameters
     * @return pagindated list of entities.
     */
    Page<T> findAll(Sort sort, PageRequest page);
}
