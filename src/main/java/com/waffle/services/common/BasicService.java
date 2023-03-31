package com.waffle.services.common;

import java.util.List;

/**
 * Generic interface with common methods for all services.
 *
 * @param <T> any valid entity that has corresponding repository
 */
public interface BasicService<T> {

    /**
     * Save new entity.
     *
     * @param payload data to save.
     * @return inserted data
     */
    T save(T payload);

    /**
     * Find all entities.
     *
     * @return list of entity
     */
    List<T> findAll();

    /**
     * Find one by id.
     *
     * @param id primary key
     * @return entity
     */
    T find(Long id);

    /**
     * Update one entity.
     *
     * @param payload data to update
     * @return updated entity
     */
    T update(T payload);

    /**
     * Delete one by id.
     *
     * @param id primary key
     */
    void delete(Long id);
}
