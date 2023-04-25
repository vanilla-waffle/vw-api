package com.waffle.services.composite.impl;

import com.waffle.data.entities.User;
import com.waffle.data.mappers.UserMapper;
import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserPublicResponseDto;
import com.waffle.data.utils.SortUtils;
import com.waffle.services.composite.UserPublicService;
import com.waffle.services.entity.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User public service implementation.
 */
@Service
@AllArgsConstructor
public class UserPublicServiceImpl implements UserPublicService {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public List<UserPublicResponseDto> findAll(final String query) {
        final Sort sort = SortUtils.from(query);
        final List<User> users = userService.findAll(sort);
        return userMapper.convertPublic(users);
    }

    @Override
    public Page<UserPublicResponseDto> findAll(final String query, final PageRequest page) {
        final Sort sort = SortUtils.from(query);
        final Page<User> users = userService.findAll(sort, page);
        return users.map(userMapper::convertPublic);
    }

    @Override
    public UserAllResponseDto save(final UserCreateDto payload) {
        User user = userMapper.convert(payload);
        user = userService.save(user);
        return userMapper.convertAll(user);
    }
}