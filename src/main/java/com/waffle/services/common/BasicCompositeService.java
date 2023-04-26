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

    All save(Create payload);

    List<Slim> findAll(String query);

    Page<Slim> findAll(String query, PageRequest page);

    All find(Long id);

    All update(Update payload);

    void delete(Long id);
}
