package com.waffle.services.entity.impl;

import com.waffle.data.entities.admin.UserModeration;
import com.waffle.data.repositories.UserModerationRepository;
import com.waffle.services.entity.UserModerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.waffle.data.repositories.specifications.UserModerationSpecification.*;

@Service
@RequiredArgsConstructor
public class UserModerationServiceImpl implements UserModerationService {
    private final UserModerationRepository repository;

    @Override
    public UserModeration save(final UserModeration payload) {
        final String licenseNumber = payload.getLicense().getLicenseNumber();

        if (exists(byUser(payload.getUser().getId()).and(hasPending()))) {
            throw new IllegalArgumentException("User already has a pending moderation request");
        }

        if (exists(byLicenseNumber(licenseNumber))) {
            throw new IllegalArgumentException("Provided license is already being moderated: " + licenseNumber);
        }

        return repository.save(payload);
    }

    @Override
    public List<UserModeration> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<UserModeration> findAll(final PageRequest page) {
        return repository.findAll(page);
    }

    @Override
    public Page<UserModeration> findAll(final Sort sort, final PageRequest page) {
        return repository.findAll(page.withSort(sort));
    }

    @Override
    public List<UserModeration> findAll(final Specification<UserModeration> by) {
        return repository.findAll(by);
    }

    @Override
    public Page<UserModeration> findAll(final Sort sort, final PageRequest page, final Specification<UserModeration> by) {
        return repository.findAll(by, page.withSort(sort));
    }

    @Override
    public UserModeration find(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Request not found: " + id));
    }

    @Override
    public UserModeration find(final Specification<UserModeration> by) {
        return repository.findOne(by).orElseThrow(() -> new IllegalArgumentException("Request not found"));
    }

    @Override
    public UserModeration merge(final UserModeration payload) {
        final Long id = payload.getId();

        if (!exists(id)) {
            throw new IllegalArgumentException("Request does not exist: " + id);
        }

        return repository.save(payload);
    }

    @Override
    public UserModeration update(final UserModeration payload) {
        return merge(payload);
    }

    @Override
    public void delete(final Long id) {
        if (!exists(id)) {
            throw new IllegalArgumentException("Request does not exist: " + id);
        }

        repository.deleteById(id);
    }

    @Override
    public boolean exists(final Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean exists(final Specification<UserModeration> by) {
        return repository.exists(by);
    }
}
