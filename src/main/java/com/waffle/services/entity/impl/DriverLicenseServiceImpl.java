package com.waffle.services.entity.impl;

import com.waffle.data.entities.DriverLicense;
import com.waffle.data.repositories.DriverLicenseRepository;
import com.waffle.services.entity.DriverLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.waffle.data.repositories.specifications.DriverLicenseSpecification.byLicenseNumber;

/**
 * Driver license service implementation.
 */
@Service
@RequiredArgsConstructor
public class DriverLicenseServiceImpl implements DriverLicenseService {
    private final DriverLicenseRepository repository;

    @Override
    public DriverLicense save(final DriverLicense payload) {
        final String licenseNumber = payload.getLicenseNumber();

        if (exists(byLicenseNumber(licenseNumber))) {
            throw new IllegalArgumentException("License is already in use: " + licenseNumber);
        }

        return repository.save(payload);
    }

    @Override
    public List<DriverLicense> findAll() {
        return repository.findAll();
    }

    @Override
    public DriverLicense find(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("License does not exist: " + id));
    }

    @Override
    public DriverLicense merge(final DriverLicense payload) {
        return update(payload);
    }

    @Override
    public DriverLicense update(final DriverLicense payload) {
        final Long id = payload.getId();

        if (!exists(id)) {
            throw new IllegalArgumentException("License does not exist: " + id);
        }

        return repository.save(payload);
    }

    @Override
    public void delete(final Long id) {
        if (!exists(id)) {
            throw new IllegalArgumentException("License does not exist: " + id);
        }

        repository.deleteById(id);
    }

    @Override
    public boolean exists(final Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean exists(final Specification<DriverLicense> by) {
        return repository.exists(by);
    }
}
