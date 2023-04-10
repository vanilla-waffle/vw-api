package com.waffle.services.common;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Service with {@link org.springframework.data.jpa.domain.Specification} used methods.
 *
 * @param <T>
 */
public interface SpecificService<T> {

    /**
     * Find one by specified parameter.
     *
     * @param by {@link Specification}
     * @return single instance
     */
    T find(Specification<T> by);

    /**
     * Find specified list.
     *
     * @param by {@link Specification}
     * @return {@link List}
     */
    List<T> findAll(Specification<T> by);
}
