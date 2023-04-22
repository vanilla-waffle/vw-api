package com.waffle.services.entity.impl;

import com.waffle.data.constants.exceptions.VehicleNotFoundException;
import com.waffle.data.entities.Vehicle;
import com.waffle.data.mappers.VehicleMapper;
import com.waffle.repositories.VehicleRepository;
import com.waffle.services.entity.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.waffle.repositories.specifications.VehicleSpecification.byUser;

/**
 * PostService implementation.
 */
@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    @Override
    public Vehicle save(final Vehicle payload) {
        return repository.save(payload);
    }

    @Override
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Vehicle> findAll(final Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public List<Vehicle> findAll(final Sort sort, final Long userId) {
        return repository.findAll(byUser(userId), sort);
    }

    @Override
    public Page<Vehicle> findAll(final Sort sort, final Long userId, final PageRequest page) {
        return repository.findAll(byUser(userId), page.withSort(sort));
    }

    @Override
    public List<Vehicle> findAll(final Long userId) {
        return repository.findAll(byUser(userId));
    }

    @Override
    public Page<Vehicle> findAll(final PageRequest page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Vehicle> findAll(final Sort sort, final PageRequest page) {
        return repository.findAll(page.withSort(sort));
    }

    @Override
    public Vehicle find(final Long id) {
        return repository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id));
    }

    @Override
    public Vehicle update(final Vehicle payload) {
        Vehicle vehicle = find(payload.getId());
        vehicle = mapper.update(payload, vehicle);
        return repository.save(vehicle);
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean exists(final Long id) {
        return repository.existsById(id);
    }
}
