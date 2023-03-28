package com.waffle.services;


import com.waffle.data.dto.other.SearchCriteria;
import com.waffle.data.entity.Vehicle;

import java.util.List;

/**
 * Post service.
 */
public interface PostService {

    /**
     * Create a new user.
     *
     * @param payload incoming post data
     * @return created post
     */
    Vehicle save(Vehicle payload);

    /**
     * Find post by post id.
     *
     * @param postId post id
     * @return user
     */
    Vehicle find(Long postId);

    /**
     * Find post by title.
     *
     * @param criteria search criteria
     * @return post
     */
    Vehicle find(SearchCriteria criteria);

    /**
     * Find all posts.
     *
     * @param criteria search criteria
     * @return posts
     */
    List<Vehicle> findAll(SearchCriteria criteria);

    /**
     * Update post.
     *
     * @param payload incoming user data
     * @return updated post
     */
    Vehicle update(Vehicle payload);

    /**
     * Delete post by id.
     *
     * @param id post id
     */
    void delete(Long id);
}
