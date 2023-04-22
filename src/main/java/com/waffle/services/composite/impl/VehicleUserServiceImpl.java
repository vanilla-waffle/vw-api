package com.waffle.services.composite.impl;

import com.waffle.data.models.rest.request.vehicle.VehicleCreateDto;
import com.waffle.data.models.rest.request.vehicle.VehicleUpdateDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.data.entities.User;
import com.waffle.data.entities.Vehicle;
import com.waffle.data.mappers.VehicleMapper;
import com.waffle.data.utils.SortUtils;
import com.waffle.services.composite.VehicleUserService;
import com.waffle.services.entity.UserService;
import com.waffle.services.entity.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User vehicle service implementation.
 */
@Service
@RequiredArgsConstructor
public class VehicleUserServiceImpl implements VehicleUserService {
    private final VehicleService vehicleService;
    private final UserService userService;
    private final VehicleMapper vehicleMapper;

    @Override
    public List<VehicleSlimResponseDto> findAll(final String query) {
        final Sort sort = SortUtils.from(query);
        final List<Vehicle> vehicles = vehicleService.findAll(sort);
        return vehicleMapper.convertSlim(vehicles);
    }

    @Override
    public List<VehicleSlimResponseDto> findAll(final String query, final Long userId) {
        final Sort sort = SortUtils.from(query);
        final List<Vehicle> vehicles = vehicleService.findAll(sort, userId);
        return vehicleMapper.convertSlim(vehicles);
    }

    @Override
    public Page<VehicleSlimResponseDto> findAll(final String query, final Long userId, final PageRequest page) {
        final Sort sort = SortUtils.from(query);
        final Page<Vehicle> vehicles = vehicleService.findAll(sort, userId, page);
        return vehicles.map(vehicleMapper::convertSlim);
    }

    @Override
    public Page<VehicleSlimResponseDto> findAll(final String query, final PageRequest page) {
        final Sort sort = SortUtils.from(query);
        final Page<Vehicle> vehicles = vehicleService.findAll(sort, page);
        return vehicles.map(vehicleMapper::convertSlim);
    }

    @Override
    public VehicleAllResponseDto find(final Long id) {
        final Vehicle vehicle = vehicleService.find(id);
        return vehicleMapper.convertAll(vehicle);
    }

    @Override
    @Transactional
    public VehicleAllResponseDto save(final VehicleCreateDto payload, final Long userId) {
        final User user = userService.find(userId);
        Vehicle vehicle = vehicleMapper.convert(payload);
        vehicle.setUser(user);
        vehicle = vehicleService.save(vehicle);
        return vehicleMapper.convertAll(vehicle);
    }

    @Override
    public VehicleAllResponseDto update(final VehicleUpdateDto payload) {
        Vehicle vehicle = vehicleMapper.convert(payload);
        vehicle = vehicleService.update(vehicle);
        return vehicleMapper.convertAll(vehicle);
    }

    @Override
    public void delete(final Long id) {
        vehicleService.delete(id);
    }
}
