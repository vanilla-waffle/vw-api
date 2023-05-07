package com.waffle.services.composite.impl;

import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.entities.User;
import com.waffle.data.utils.mappers.UserMapper;
import com.waffle.data.models.rest.request.user.UserUpdateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.services.utils.Sorts;
import com.waffle.services.composite.UserInternalService;
import com.waffle.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public List<UserSlimResponseDto> findAll(final String query) {
        final Sort sort = Sorts.of(query);
        final List<User> users = userService.findAll(sort);
        return userMapper.convertSlim(users);
    }

    @Override
    public Page<UserSlimResponseDto> findAll(final String query, final PageRequest page) {
        final Sort sort = Sorts.of(query);
        final Page<User> users = userService.findAll(sort, page);
        return users.map(userMapper::convertSlim);
    }

    @Override
    public UserAllResponseDto find(final Long id) {
        final User user = userService.find(id);
        return userMapper.convertAll(user);
    }

    @Override
    public UserAllResponseDto update(final UserUpdateDto payload) {
        User user = userMapper.convert(payload);
        user = userService.merge(user);
        return userMapper.convertAll(user);
    }

    @Override
    public UserAllResponseDto activate(final Long id) {
        User user = userService.find(id);

        if (user.getStatus().equals(UserStatus.ACTIVE)) {
            throw new IllegalArgumentException("User is already active: " + id);
        }

        user.setStatus(UserStatus.ACTIVE);
        user = userService.update(user);
        return userMapper.convertAll(user);
    }

    @Override
    public UserAllResponseDto delete(final Long id) {
        User user = userService.find(id);

        if (user.getStatus().equals(UserStatus.DELETED)) {
            throw new IllegalArgumentException("User is already marked as deleted: " + id);
        }

        user.setStatus(UserStatus.DELETED);
        user = userService.update(user);
        return userMapper.convertAll(user);
    }

    @Override
    @Transactional
    public void erase(final Long id) {
        userService.delete(id);
    }
}
