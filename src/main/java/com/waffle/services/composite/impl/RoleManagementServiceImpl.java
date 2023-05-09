package com.waffle.services.composite.impl;

import com.waffle.data.constants.types.user.RoleType;
import com.waffle.data.entities.Role;
import com.waffle.data.entities.User;
import com.waffle.data.utils.mappers.RoleMapper;
import com.waffle.data.utils.mappers.UserMapper;
import com.waffle.data.models.rest.request.user.role.RoleCreateDto;
import com.waffle.data.models.rest.response.user.role.RoleResponseAllDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.services.utils.Sorts;
import com.waffle.services.composite.RoleManagementService;
import com.waffle.services.entity.RoleService;
import com.waffle.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Role management service implementation.
 */
@Service
@RequiredArgsConstructor
public class RoleManagementServiceImpl implements RoleManagementService {
    private final RoleService roleService;
    private final UserService userService;
    private final RoleMapper roleMapper;
    private final UserMapper userMapper;

    @Override
    public UserAllResponseDto promote(final Long id, final RoleType type) {
        final User user = userService.find(id);
        final Role role = roleService.find(type);

        if (role.getUsers().contains(user)) {
            throw new IllegalArgumentException("User has been already promoted to: " + type.name());
        }

        role.getUsers().add(user);
        roleService.merge(role);

        return userMapper.convertAll(user);
    }

    @Override
    public UserAllResponseDto demote(final Long id, final RoleType type) {
        final User user = userService.find(id);
        final Role role = roleService.find(type);

        if (!role.getUsers().contains(user)) {
            throw new IllegalArgumentException("User never had the provided role: " + type.name());
        }

        role.getUsers().remove(user);
        roleService.merge(role);

        return userMapper.convertAll(user);
    }

    @Override
    public Page<RoleResponseAllDto> findAll(final String query, final PageRequest page) {
        final Sort sort = Sorts.of(query);
        final Page<Role> roles = roleService.findAll(sort, page);
        return roles.map(roleMapper::convertAll);
    }

    @Override
    public RoleResponseAllDto find(final Long id) {
        final Role role = roleService.find(id);
        return roleMapper.convertAll(role);
    }

    @Override
    public RoleResponseAllDto find(final RoleType type) {
        final Role role = roleService.find(type);
        return roleMapper.convertAll(role);
    }

    @Override
    public RoleResponseAllDto save(final RoleCreateDto payload) {
        Role role = roleMapper.convert(payload);
        role = roleService.save(role);
        return roleMapper.convertAll(role);
    }

    @Override
    public void delete(final Long id) {
        roleService.delete(id);
    }
}
