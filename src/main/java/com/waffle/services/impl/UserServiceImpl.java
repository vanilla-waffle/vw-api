package com.waffle.services.impl;

import com.waffle.data.dto.other.SearchCriteria;
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
        return repository.findOne(byId(id)).orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
    }

    @Override
    public User find(final SearchCriteria criteria) {
        return repository.findOne(by(criteria)).orElseThrow(() -> new IllegalArgumentException("User not found: " + criteria.getValue()));
    }

    @Override
    public List<User> findAll(final SearchCriteria criteria) {
        if (criteria.getKey() == null) {
            return repository.findAll();
        }

        return repository.findAll(by(criteria));
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
    public void delete(final String email) {
        User user = findByEmail(email);
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

    private User findByEmail(final String email) {
        return repository.findOne(byEmail(email)).orElseThrow(IllegalArgumentException::new);
    }
}
