package com.waffle.services.entity.impl;

import com.waffle.data.constants.exceptions.UserAlreadyExistsException;
import com.waffle.data.constants.exceptions.UserNotFoundException;
import com.waffle.data.entities.User;
import com.waffle.data.entities.embedded.user.Profile;
import com.waffle.data.mappers.UserMapper;
import com.waffle.repositories.UserRepository;
import com.waffle.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.waffle.repositories.specifications.UserSpecification.byEmail;
import static com.waffle.repositories.specifications.UserSpecification.byUsername;

/**
 * UserService implementation.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public User save(final User payload) {
        exists(payload.getProfile());
        return repository.save(payload);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User find(final Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User find(final String username) {
        return repository.findOne(byUsername(username)).orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public User update(final User payload) {
        exists(payload.getProfile());
        final User actual = find(payload.getId());
        User user = mapper.update(payload, actual);
        return repository.save(user);
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> findAll(final Sort sort) {
        return repository.findAll(sort);
    }

    private void exists(final Profile p) {
        if (p.getEmail() != null && repository.exists(byEmail(p.getEmail()))) {
            throw new UserAlreadyExistsException(p.getEmail());
        }
        if (p.getUsername() != null && repository.exists(byUsername(p.getUsername()))) {
            throw new UserAlreadyExistsException(p.getUsername());
        }
    }
}
