package com.waffle.data.repositories;

import com.waffle.data.entities.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Image repository.
 */
@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

    /**
     * Find by uuid.
     *
     * @param uuid {@link String}
     * @return {@link Optional} of {@link Image}
     */
    Optional<Image> findByUuid(@NonNull String uuid);

    /**
     * Delete by uuid.
     *
     * @param uuid {@link String}
     */
    void deleteByUuid(@NonNull String uuid);
}
