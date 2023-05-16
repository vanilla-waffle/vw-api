package com.waffle.services.common;

import java.util.List;

/**
 * Readonly service.
 *
 * @param <T> entity
 * @param <ID> primary key
 */
public interface ReadonlyService<T, ID> {

    /**
     * Find all.
     *
     * @return {@link List}
     */
    List<T> findAll();

    /**
     * Find one.
     *
     * @param id {@link T}
     * @return {@link T}
     */
    T find(ID id);
}
