package com.waffle.services.common;

import com.waffle.data.entities.root.BasicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Generic service of common methods with paging abilities.
 *
 * @param <T> any valid entity that has corresponding repository
 */
public interface PagingService<T extends BasicEntity> {

    /**
     * Find all entities with pagination.
     *
     * @param page {@link PageRequest}
     * @return paginated list of entities
     */
    Page<T> findAll(PageRequest page);

    /**
     * Find all entities sorted with pagination.
     *
     * @param sort {@link Sort}
     * @param page {@link PageRequest}
     * @return paginated list of entities.
     */
    Page<T> findAll(Sort sort, PageRequest page);
}
