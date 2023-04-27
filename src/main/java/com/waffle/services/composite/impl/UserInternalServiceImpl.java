package com.waffle.services.composite.impl;

import com.waffle.data.entities.User;
import com.waffle.data.mappers.UserMapper;
import com.waffle.data.models.rest.request.user.UserUpdateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.data.utils.Sorts;
import com.waffle.services.composite.UserInternalService;
import com.waffle.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User internal service implementation.
 */
@Service
@RequiredArgsConstructor
public class UserInternalServiceImpl implements UserInternalService {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public List<UserSlimResponseDto> findAll(final String sort) {
        if (sort == null) {
            final List<User> users = userService.findAll();
            return userMapper.convertSlim(users);
        }

        final Sort params = Sorts.of(sort);
        final List<User> users = userService.findAll(params);
        return userMapper.convertSlim(users);
    }

    @Override
    public UserAllResponseDto find(final Long id) {
        final User user = userService.find(id);
        return userMapper.convertAll(user);
    }

    @Override
    public UserAllResponseDto update(final UserUpdateDto payload) {
        User user = userMapper.convert(payload);
        user = userService.update(user);
        return userMapper.convertAll(user);
    }

    @Override
    public void delete(final Long id) {
        userService.delete(id);
    }
}
