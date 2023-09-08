package com.waffle.services.common;

import com.waffle.data.entities.root.BasicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * Filtering service.
 *
 * @param <T> any entity
 */
public interface FilteringService<T extends BasicEntity> {

    /**
     * Find all matching the given {@link Map} of parameters.
     *
     * @param params {@link Map}
     * @return {@link List}
     */
    List<T> findAll(Map<String, String> params);

    /**
     * Find all matching the given {@link Map} of parameters.
     *
     * @param params {@link Map}
     * @param page   {@link PageRequest}
     * @return {@link Page}
     */
    Page<T> findAll(Map<String, String> params, PageRequest page);
}
