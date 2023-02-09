package com.waffle.services;

import com.waffle.dto.PostDto;

/**
 * User post service interface.
 */
public interface UserPostService {

    /**
     * Create new post.
     *
     * @param post post dto
     * @param ownerEmail owner email
     * @return created post
     */
    PostDto.Response.All create(PostDto.Request.Create post, String ownerEmail);

    /**
     * Find post by title.
     *
     * @param title post title
     * @return post slim dto
     */
    PostDto.Response.Slim find(String title);
}
