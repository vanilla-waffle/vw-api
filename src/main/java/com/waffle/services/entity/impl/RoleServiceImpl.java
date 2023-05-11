package com.waffle.services.entity.impl;

import com.waffle.data.constants.types.user.RoleType;
import com.waffle.data.entities.Role;
import com.waffle.data.repositories.RoleRepository;
import com.waffle.services.entity.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.waffle.data.repositories.specifications.RoleSpecification.byRoleType;

/**
 * Role service implementation.
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role save(final Role payload) {
        if (exists(payload.getRole().name())) {
            throw new IllegalArgumentException("Role already defined: " + payload.getRole().name());
        }

        return repository.save(payload);
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Role> findAll(final PageRequest page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Role> findAll(final Sort sort, final PageRequest page) {
        return repository.findAll(page.withSort(sort));
    }

    @Override
    public Role find(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role does not exist: " + id));
    }

    @Override
    public Role find(final RoleType role) {
        return repository.findOne(byRoleType(role)).orElseThrow(() -> new IllegalArgumentException("Role does not exist: " + role));
    }

    @Override
    public Role merge(final Role payload) {
        if (!exists(payload.getId())) {
            throw new IllegalArgumentException("Role does not exist: " + payload.getId());
        }

        return repository.save(payload);
    }

    @Override
    public Role update(final Role payload) {
        if (!exists(payload.getId())) {
            throw new IllegalArgumentException("Role does not exist: " + payload.getId());
        }

        return repository.save(payload);
    }

    @Override
    public void delete(final Long id) {
        if (!exists(id)) {
            throw new IllegalArgumentException("Role does not exist: " + id);
        }

        repository.deleteById(id);
    }

    @Override
    public boolean exists(final Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean exists(final String name) {
        final Role role = new Role(RoleType.valueOf(name), null);
        final Example<Role> example = Example.of(role);
        return repository.exists(example);
    }
}
