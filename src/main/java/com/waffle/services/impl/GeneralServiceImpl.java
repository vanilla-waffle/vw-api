package com.waffle.services.impl;

import com.waffle.data.dto.request.PostCreateDto;
import com.waffle.data.dto.request.PostUpdateDto;
import com.waffle.data.dto.request.user.UserCreateDto;
import com.waffle.data.dto.request.user.UserUpdateDto;
import com.waffle.data.dto.response.PostAllDto;
import com.waffle.data.dto.response.UserAllDto;
import com.waffle.data.dto.response.UserSlimDto;
import com.waffle.mappers.PostMapper;
import com.waffle.mappers.UserMapper;
import com.waffle.data.entity.Vehicle;
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
        Vehicle vehicle = postMapper.fromCreateDtoToPost(payload);
        User user = userService.find(payload.getAuthorId());

        vehicle.setUser(user);
//        user.getPosts().add(vehicle);

        vehicle = postService.save(vehicle);
        userService.update(user);
        return postMapper.fromPostToAllDto(vehicle);
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
        Vehicle vehicle = postMapper.fromUpdateDtoToPost(payload);
        vehicle = postService.update(vehicle);
        return postMapper.fromPostToAllDto(vehicle);
    }

    @Override
    public void delete(@NotNull final Long userId) {
        userService.delete(userId);
    }

    @Override
    public void delete(@NotNull final Long postId, @NotNull final Long authorId) {
        User user = userService.find(authorId);
        Vehicle vehicle = postService.find(postId);

//        user.getPosts().remove(vehicle);

        userService.update(user);
    }
}
