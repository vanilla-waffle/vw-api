package com.waffle.services;

import com.waffle.data.dto.request.PostCreateDto;
import com.waffle.data.dto.request.UserCreateDto;
import com.waffle.data.dto.response.PostAllDto;
import com.waffle.data.dto.response.UserSlimDto;

/**
 * Bridge service between User and Post services.
 */
public interface GeneralService {

    PostAllDto save(PostCreateDto payload, Long authorId);

    UserSlimDto save(UserCreateDto payload);

    void delete(Long userId);

    void delete(Long postId, Long authorId);
}
