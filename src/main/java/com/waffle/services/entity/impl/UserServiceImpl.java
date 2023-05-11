package com.waffle.services.entity.impl;

import com.waffle.data.entities.User;
import com.waffle.data.entities.embedded.user.Profile;
import com.waffle.data.utils.mappers.UserMapper;
import com.waffle.data.repositories.UserRepository;
import com.waffle.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

import static com.waffle.data.repositories.specifications.UserSpecification.byEmail;
import static com.waffle.data.repositories.specifications.UserSpecification.byUsername;

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
        ifExists(payload.getProfile(), (s) -> new IllegalArgumentException("Profile already exists: " + s));

        encode(payload);
        return repository.save(payload);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findAll(final Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public List<User> findAll(final Specification<User> by) {
        return repository.findAll(by);
    }

    @Override
    public Page<User> findAll(final PageRequest page) {
        return repository.findAll(page);
    }

    @Override
    public Page<User> findAll(final Sort sort, final PageRequest page) {
        return repository.findAll(page.withSort(sort));
    }

    @Override
    public User find(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
    }

    @Override
    public User find(final String username) {
        return repository.findOne(byUsername(username)).orElseThrow(() -> new IllegalArgumentException("User not found: " + username));
    }

    @Override
    public User find(final Specification<User> by) {
        return repository.findOne(by).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public User merge(final User payload) {
        ifExists(payload.getProfile(), (s) -> new IllegalArgumentException("Profile already exists: " + s));

        User actual = find(payload.getId());
        actual = mapper.update(payload, actual);
        return repository.save(actual);
    }

    @Override
    public User update(final User payload) {
        if (!exists(payload.getId())) {
            throw new IllegalArgumentException("User does not exist: " + payload.getId());
        }

        return repository.save(payload);
    }

    @Override
    public void delete(final Long id) {
        if (!exists(id)) {
            throw new IllegalArgumentException("User does not exist: " + id);
        }

        repository.deleteById(id);
    }

    @Override
    public boolean exists(final Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean exists(final Specification<User> by) {
        return repository.exists(by);
    }

    private void ifExists(final Profile p, final Function<String, ? extends RuntimeException> supplier) {
        final String username = p.getUsername();
        final String email = p.getEmail();

        if (exists(byEmail(email))) {
            throw supplier.apply(email);
        }

        if (exists(byUsername(username))) {
            throw supplier.apply(username);
        }
    }

    private void encode(final User user) {
        final String hashed = new BCryptPasswordEncoder().encode(user.getProfile().getPassword());
        user.getProfile().setPassword(hashed);
    }
}
