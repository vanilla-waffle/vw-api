package com.waffle.data.repositories;

import com.waffle.data.entities.root.BasicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repository that consumes filter parameters.
 *
 * @param <T> entity
 * @param <ID> id
 */
@NoRepositoryBean
public interface FilteredJpaRepository<T extends BasicEntity, ID> extends JpaRepository<T, ID> {

    /**
     * Find all matching.
     *
     * @param params cannot be {@code null}
     * @return never {@code null}
     */
    List<T> findAll(Map<String, String> params);

    /**
     * Find all matching the given {@link Pageable}.
     *
     * @param params   cannot be {@code null}
     * @param pageable cannot be {@code null}
     * @return never {@code null}
     */
    Page<T> findAll(Map<String, String> params, Pageable pageable);
}
