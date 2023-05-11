package com.waffle.data.repositories;

import com.waffle.data.entities.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Image repository.
 */
@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
}
