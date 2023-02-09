package com.waffle.services.impl;

import com.google.common.collect.Lists;
import com.waffle.dto.UserDto;
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
    public User save(final UserDto.Request.Create payload) {
        if (exists(payload.getProfile().getEmail())) {
            throw new IllegalArgumentException();
        }

        User user = mapper.createdToUser(payload);
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
    public User update(final UserDto.Request.Create payload) {
        if (!exists(payload.getProfile().getEmail())) {
            throw new IllegalArgumentException();
        }

        User user = find(payload.getProfile().getEmail());
        User updatedUser = mapper.toUpdatedUser(payload, user);

        return repository.save(updatedUser);
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }

    private boolean exists(final String email) {
        return repository.existsByProfileEmail(email);
    }
}
