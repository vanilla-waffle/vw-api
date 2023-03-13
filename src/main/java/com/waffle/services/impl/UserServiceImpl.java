package com.waffle.services.impl;

import com.google.common.collect.Lists;
import com.waffle.dto.request.UserCreateDto;
import com.waffle.dto.request.UserUpdateDto;
import com.waffle.mappers.UserMapper;
import com.waffle.models.entity.User;
import com.waffle.repositories.UserRepository;
import com.waffle.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService implementation.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public User save(final UserCreateDto payload) {
        if (exists(payload.getEmail())) {
            throw new IllegalArgumentException();
        }

        User user = mapper.userCreateDtoToUser(payload);
        return repository.save(user);
    }

    @Override
    public User find(final Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public User find(final String email) {
        return repository.findByProfileEmail(email).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<User> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public User update(final UserUpdateDto payload) {
        if (!exists(payload.getProfile().getEmail())) {
            throw new IllegalArgumentException();
        }

        User user = find(payload.getProfile().getEmail());
        mapper.updateUserFromUserUpdateDto(payload, user);

        return repository.save(user);
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }

    private boolean exists(final String email) {
        return repository.existsByProfileEmail(email);
    }
}
