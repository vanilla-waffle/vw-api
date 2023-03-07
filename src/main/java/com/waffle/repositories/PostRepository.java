package com.waffle.repositories;

import com.waffle.model.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Post repository.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}