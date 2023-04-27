package com.waffle.services.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Basic composite service.
 *.
 * @param <Create> create dto
 * @param <Update> update dto
 * @param <All> all response dto
 * @param <Slim> slim response dto
 */
public interface BasicCompositeService<Create, Update, All, Slim> {

    /**
     * Save.
     *
     * @param payload {@link Create}
     * @return {@link All}
     */
    All save(Create payload);

    /**
     * Find all.
     *
     * @param query {@link String}
     * @return {@link List<Slim>}
     */
    List<Slim> findAll(String query);

    /**
     * Find all.
     *
     * @param query {@link String}
     * @param page {@link PageRequest}
     * @return {@link Page<Slim>}
     */
    Page<Slim> findAll(String query, PageRequest page);

    /**
     * Find.
     *
     * @param id {@link Long}
     * @return {@link All}
     */
    All find(Long id);

    /**
     * Update.
     *
     * @param payload {@link Update}
     * @return {@link All}
     */
    All update(Update payload);

    /**
     * Delete.
     *
     * @param id {@link Long}
     */
    void delete(Long id);
}
