package com.waffle.services.composite.impl;

import com.waffle.data.models.rest.request.vehicle.VehicleCreateDto;
import com.waffle.data.models.rest.request.vehicle.VehicleUpdateDto;
import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.request.user.UserUpdateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserPublicResponseDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.data.entities.User;
import com.waffle.data.entities.Vehicle;
import com.waffle.data.mappers.UserMapper;
import com.waffle.data.mappers.VehicleMapper;
import com.waffle.data.utils.SortUtils;
import com.waffle.services.composite.UserVehicleService;
import com.waffle.services.entity.UserService;
import com.waffle.services.entity.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.waffle.repositories.specifications.UserSpecification.byUsername;

/**
 * User vehicle service implementation.
 */
@Service
@RequiredArgsConstructor
public class UserVehicleServiceImpl implements UserVehicleService {
    private final UserService userService;
    private final VehicleService vehicleService;
    private final UserMapper userMapper;
    private final VehicleMapper vehicleMapper;

    @Override
    public List<UserSlimResponseDto> findAllUsers(final String sort) {
        if (sort == null) {
            final List<User> users = userService.findAll();
            return userMapper.convertSlim(users);
        }

        final Sort params = SortUtils.from(sort);
        final List<User> users = userService.findAll(params);
        return userMapper.convertSlim(users);
    }

    @Override
    public List<UserPublicResponseDto> findAllPublicUsers(final String sort) {
        if (sort == null) {
            final List<User> users = userService.findAll();
            return userMapper.convertPublic(users);
        }

        final Sort params = SortUtils.from(sort);
        final List<User> users = userService.findAll(params);
        return userMapper.convertPublic(users);
    }

    @Override
    public UserAllResponseDto findUserById(final Long id) {
        final User user = userService.find(id);
        return userMapper.convertAll(user);
    }

    @Override
    public UserAllResponseDto findUserByUsername(final String username) {
        final User user = userService.find(byUsername(username));
        return userMapper.convertAll(user);
    }

    @Override
    public UserAllResponseDto saveUser(final UserCreateDto payload) {
        User user = userMapper.convert(payload);
        user = userService.save(user);
        return userMapper.convertAll(user);
    }

    @Override
    public UserAllResponseDto updateUser(final UserUpdateDto payload) {
        User user = userMapper.convert(payload);
        user = userService.update(user);
        return userMapper.convertAll(user);
    }

    @Override
    public void deleteUser(final Long id) {
        userService.delete(id);
    }

    @Override
    public List<VehicleSlimResponseDto> findAllVehicles(final String sort) {
        if (sort == null) {
            final List<Vehicle> vehicles = vehicleService.findAll();
            return vehicleMapper.convertSlim(vehicles);
        }

        final Sort query = SortUtils.from(sort);
        final List<Vehicle> vehicles = vehicleService.findAll(query);
        return vehicleMapper.convertSlim(vehicles);
    }

    @Override
    public List<VehicleSlimResponseDto> findAllVehicles(final String sort, final Long userId) {
        if (sort == null) {
            final List<Vehicle> vehicles = vehicleService.findAll(userId);
            return vehicleMapper.convertSlim(vehicles);
        }

        final Sort query = SortUtils.from(sort);
        final List<Vehicle> vehicles = vehicleService.findAll(query, userId);
        return vehicleMapper.convertSlim(vehicles);
    }

    @Override
    public VehicleAllResponseDto findVehicleById(final Long id) {
        final Vehicle vehicle = vehicleService.find(id);
        return vehicleMapper.convertAll(vehicle);
    }

    @Override
    @Transactional
    public VehicleAllResponseDto saveVehicle(final VehicleCreateDto payload, final Long userId) {
        final User user = userService.find(userId);
        Vehicle vehicle = vehicleMapper.convert(payload);
        vehicle.setUser(user);
        vehicle = vehicleService.save(vehicle);
        return vehicleMapper.convertAll(vehicle);
    }

    @Override
    public VehicleAllResponseDto updateVehicle(final VehicleUpdateDto payload) {
        Vehicle vehicle = vehicleMapper.convert(payload);
        vehicle = vehicleService.update(vehicle);
        return vehicleMapper.convertAll(vehicle);
    }

    @Override
    public void deleteVehicle(final Long id) {
        vehicleService.delete(id);
    }
}
