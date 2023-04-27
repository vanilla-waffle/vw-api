package com.waffle.services.composite.impl;

import com.waffle.data.constants.types.user.RoleType;
import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.entities.Role;
import com.waffle.data.entities.User;
import com.waffle.data.mappers.UserMapper;
import com.waffle.data.models.rest.request.user.UserUpdateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.data.utils.Sorts;
import com.waffle.services.composite.UserInternalService;
import com.waffle.services.entity.RoleService;
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
    private final RoleService roleService;
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
        user = userService.update(user);
        return userMapper.convertAll(user);
    }

    @Override
    public UserAllResponseDto activate(final Long id) {
        final User user = userService.changeStatus(id, UserStatus.ACTIVE);
        return userMapper.convertAll(user);
    }

    @Override
    public UserAllResponseDto delete(final Long id) {
        final User user = userService.changeStatus(id, UserStatus.DELETED);
        return userMapper.convertAll(user);
    }

    @Override
    @Transactional
    public void erase(final Long id) {
        userService.delete(id);
    }

    @Override
    public UserAllResponseDto grant(final Long id, final RoleType roleType) {
        final User user = userService.find(id);
        Role role = roleService.find(roleType);
        role.getUsers().add(user);
        roleService.update(role);
        return userMapper.convertAll(user);
    }
}
