package com.waffle.services.impl;

import com.waffle.data.dto.request.PostCreateDto;
import com.waffle.data.dto.request.PostUpdateDto;
import com.waffle.data.dto.request.UserCreateDto;
import com.waffle.data.dto.request.UserUpdateDto;
import com.waffle.data.dto.response.PostAllDto;
import com.waffle.data.dto.response.UserAllDto;
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

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

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
    @Transactional
    public PostAllDto save(@NotNull final PostCreateDto payload) {
        Post post = postMapper.fromCreateDtoToPost(payload);
        User user = userService.find(payload.getAuthorId());

        post.setUser(user);
        user.getPosts().add(post);

        post = postService.save(post);
        userService.update(user);
        return postMapper.fromPostToAllDto(post);
    }

    @Override
    @Transactional
    public UserSlimDto save(@NotNull final UserCreateDto payload) {
        User user = userMapper.fromCreateDtoToUser(payload);
        user = userService.save(user);
        return userMapper.fromUserToSlimDto(user);
    }

    @Override
    public UserAllDto update(@NotNull final UserUpdateDto payload) {
        User user = userMapper.fromUpdateDtoToUser(payload);
        user = userService.update(user);
        return userMapper.fromUserToAllDto(user);
    }

    @Override
    public PostAllDto update(@NotNull final PostUpdateDto payload) {
        Post post = postMapper.fromUpdateDtoToPost(payload);
        post = postService.update(post);
        return postMapper.fromPostToAllDto(post);
    }

    @Override
    public void delete(@NotNull final Long userId) {
        userService.delete(userId);
    }

    @Override
    public void delete(@NotNull final Long postId, @NotNull final Long authorId) {
        User user = userService.find(authorId);
        Post post = postService.find(postId);

        user.getPosts().remove(post);

        userService.update(user);
    }
}
