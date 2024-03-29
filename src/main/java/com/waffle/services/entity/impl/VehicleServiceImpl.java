package com.waffle.services.entity.impl;

import com.waffle.data.entities.Vehicle;
import com.waffle.data.utils.mappers.VehicleMapper;
import com.waffle.data.repositories.VehicleRepository;
import com.waffle.services.entity.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.waffle.data.repositories.specifications.VehicleSpecification.byUser;

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
    public List<Vehicle> findAll(final Map<String, String> params) {
        return repository.findAll(params);
    }

    @Override
    public Page<Vehicle> findAll(final Map<String, String> params, final PageRequest page) {
        return repository.findAll(params, page);
    }

    @Override
    public Vehicle find(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Vehicle does not exist: " + id));
    }

    @Override
    public Vehicle merge(final Vehicle payload) {
        Vehicle vehicle = find(payload.getId());
        vehicle = mapper.update(payload, vehicle);
        return repository.save(vehicle);
    }

    @Override
    public Vehicle update(final Vehicle payload) {
        if (!exists(payload.getId())) {
            throw new IllegalArgumentException("Vehicle does not exist: " + payload.getId());
        }

        return repository.save(payload);
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
