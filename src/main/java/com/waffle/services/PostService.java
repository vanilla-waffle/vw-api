package com.waffle.services;


import com.waffle.data.entity.Post;

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
    Post save(Post payload);

    /**
     * Find post by post id.
     *
     * @param postId post id
     * @return user
     */
    Post find(Long postId);

    /**
     * Find all posts.
     *
     * @return posts
     */
    List<Post> findAll();

    /**
     * Update post.
     *
     * @param payload incoming user data
     * @return updated post
     */
    Post update(Post payload);

    /**
     * Delete post by id.
     *
     * @param id post id
     */
    void delete(Long id);
}
