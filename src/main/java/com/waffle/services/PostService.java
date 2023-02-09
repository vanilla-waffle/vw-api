package com.waffle.services;


import com.waffle.dto.PostDto;
import com.waffle.models.entity.Post;

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
    Post save(PostDto.Request.Create payload);

    /**
     * Find post by user id.
     *
     * @param userId user id
     * @return user
     */
    Post find(Long userId);

    /**
     * Find all posts.
     *
     * @return posts
     */
    List<Post> findAll();

    /**
     * Update post.
     *
     * @param post incoming user data
     * @return updated post
     */
    Post update(Post post);

    /**
     * Delete post by id.
     *
     * @param id post id
     */
    void delete(Long id);
}
