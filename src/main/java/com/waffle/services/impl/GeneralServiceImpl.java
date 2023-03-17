package com.waffle.services.impl;

import com.waffle.data.dto.request.PostCreateDto;
import com.waffle.data.dto.request.UserCreateDto;
import com.waffle.data.dto.response.PostAllDto;
import com.waffle.data.dto.response.UserSlimDto;
import com.waffle.mappers.PostMapper;
import com.waffle.mappers.UserMapper;
import com.waffle.data.entity.Post;
import com.waffle.data.entity.User;
import com.waffle.services.GeneralService;
import com.waffle.services.PostService;
import com.waffle.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * General service implementation.
 */
@Service
@RequiredArgsConstructor
public class GeneralServiceImpl implements GeneralService {
    private final UserService userService;
    private final PostService postService;

    private final PostMapper postMapper;
    private final UserMapper userMapper;

    @Override
    public PostAllDto save(final PostCreateDto payload, final Long authorId) {
        Post post = postMapper.postCreateDtoToPost(payload);
        User user = userService.find(authorId);

        post.setUser(user);
        user.getPosts().add(post);

        userService.update(user);
        return null;
    }

    @Override
    public UserSlimDto save(final UserCreateDto payload) {
        User user = userMapper.createDtoToUser(payload);
        userService.save(user);
        return null;
    }

    @Override
    public void delete(final Long userId) {
        userService.delete(userId);
    }

    @Override
    public void delete(final Long postId, final Long authorId) {
        User user = userService.find(authorId);
        Post post = postService.find(postId);

        user.getPosts().remove(post);

        userService.update(user);
    }
}
