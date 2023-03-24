package com.waffle.services.impl;

import com.waffle.data.dto.other.SearchCriteria;
import com.waffle.data.entity.User;
import com.waffle.repositories.UserRepository;
import com.waffle.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
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
    public User save(@NotNull final User payload) {
        if (exists(payload.getProfile().getEmail())) {
            throw new IllegalArgumentException();
        }

        return repository.save(payload);
    }

    @Override
    public User find(@NotNull final Long id) {
        return repository.findOne(byId(id)).orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
    }

    @Override
    public User find(@NotNull final SearchCriteria criteria) {
        return repository.findOne(by(criteria)).orElseThrow(() -> new IllegalArgumentException("User not found: " + criteria.getValue()));
    }

    @Override
    public List<User> findAll(@NotNull final SearchCriteria criteria) {
        if (criteria.getKey() == null) {
            return repository.findAll();
        }

        return repository.findAll(by(criteria));
    }

    @Override
    public User update(@NotNull final User payload) {
        if (!exists(payload.getProfile().getEmail())) {
            throw new IllegalArgumentException();
        }

        return repository.save(payload);
    }

    @Override
    public void delete(@NotNull final Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(@NotNull final String email) {
        User user = findByEmail(email);
        repository.deleteById(user.getId());
    }

    @Override
    public boolean exists(@NotNull final String email) {
        return repository.exists(byEmail(email));
    }

    @Override
    public boolean exists(@NotNull final Long id) {
        return repository.existsById(id);
    }

    private User findByEmail(@NotNull final String email) {
        return repository.findOne(byEmail(email)).orElseThrow(IllegalArgumentException::new);
    }
}
