package com.waffle.services.entity.impl;

import com.waffle.data.entities.admin.VehicleModeration;
import com.waffle.data.repositories.VehicleModerationRepository;
import com.waffle.services.entity.VehicleModerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Vehicle moderation service implementation.
 */
@Service
@RequiredArgsConstructor
public class VehicleModerationServiceImpl implements VehicleModerationService {
    private final VehicleModerationRepository repository;

    @Override
    public VehicleModeration save(final VehicleModeration payload) {
        return null;
    }

    @Override
    public List<VehicleModeration> findAll() {
        return null;
    }

    @Override
    public Page<VehicleModeration> findAll(final PageRequest page) {
        return null;
    }

    @Override
    public Page<VehicleModeration> findAll(final Sort sort, final PageRequest page) {
        return null;
    }

    @Override
    public VehicleModeration find(final Long id) {
        return null;
    }

    @Override
    public VehicleModeration merge(final VehicleModeration payload) {
        return null;
    }

    @Override
    public VehicleModeration update(final VehicleModeration payload) {
        return null;
    }

    @Override
    public void delete(final Long id) {

    }

    @Override
    public boolean exists(final Long id) {
        return false;
    }
}
