package com.waffle.services.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Generic service of common methods with paging abilities.
 *
 * @param <T> any valid entity that has corresponding repository
 */
public interface PagingService<T> {

    /**
     * Find all entities with pagination.
     *
     * @param page pagination parameters
     * @return paginated list of entities
     */
    Page<T> findAll(PageRequest page);

    /**
     * Find all entities sorted with pagination.
     *
     * @param sort sort parameters
     * @param page pagination parameters
     * @return pagindated list of entities.
     */
    Page<T> findAll(Sort sort, PageRequest page);
}
