package com.waffle.services.common;

import com.waffle.data.entities.root.BasicEntity;

import java.util.List;

/**
 * Generic interface with common methods for all services.
 *
 * @param <T> any valid entity that has corresponding repository
 */
public interface BasicService<T extends BasicEntity> {

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
     * Merge updated fields to entity.
     *
     * @param payload data to merge
     * @return updated entity
     */
    T merge(T payload);

    /**
     * Update entity.
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

    /**
     * Exists by id.
     *
     * @param id {@link Long}
     * @return {@code boolean}
     */
    boolean exists(Long id);
}
