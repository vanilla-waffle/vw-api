package com.waffle.services.impl;

import com.google.common.collect.Lists;
import com.waffle.data.entity.User;
import com.waffle.repositories.UserRepository;
import com.waffle.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.waffle.repositories.specifications.UserSpecification.*;

/**
 * UserService implementation.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public User save(final User payload) {
        if (exists(payload.getProfile().getEmail())) {
            throw new IllegalArgumentException();
        }

        return repository.save(payload);
    }

    @Override
    public User find(final Long id) {
        return repository.findOne(byId(id)).orElseThrow(IllegalAccessError::new);
    }

    @Override
    public User find(final String email) {
        return repository.findOne(byEmail(email)).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<User> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public User update(final User payload) {
        if (!exists(payload.getProfile().getEmail())) {
            throw new IllegalArgumentException();
        }

        return repository.save(payload);
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }

    @Override
    @Deprecated
    public void delete(final String email) {
        User user = find(email);
        repository.deleteById(user.getId());
    }

    @Override
    public boolean exists(final String email) {
        return repository.exists(byEmail(email));
    }

    @Override
    public boolean exists(final Long id) {
        return repository.existsById(id);
    }
}
