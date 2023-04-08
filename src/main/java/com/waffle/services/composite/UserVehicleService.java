package com.waffle.services.composite;

import com.waffle.data.models.rest.request.vehicle.VehicleCreateDto;
import com.waffle.data.models.rest.request.vehicle.VehicleUpdateDto;
import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.request.user.UserUpdateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserPublicResponseDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.data.entities.Vehicle;
import com.waffle.data.entities.User;

import java.util.List;

/**
 * User vehicle service.
 */
public interface UserVehicleService {

    /**
     * Find all {@link User}.
     *
     * @param sort {@link String} sort query
     * @return {@link List<UserAllResponseDto>}
    */
    List<UserSlimResponseDto> findAllUsers(String sort);

    /**
     * Find all public {@link User}.
     *
     * @param sort {@link String} sort query
     * @return {@link List<UserPublicResponseDto>}
     */
    List<UserPublicResponseDto> findAllPublicUsers(String sort);

    /**
     * Find one {@link User}.
     *
     * @param id {@link Long} user id
     * @return {@link UserAllResponseDto}
     */
    UserAllResponseDto findUserById(Long id);

    /**
     * Find one {@link User}.
     *
     * @param username {@link String} username
     * @return {@link UserAllResponseDto}
     */
    UserAllResponseDto findUserByUsername(String username);

    /**
     * Save one {@link User}.
     *
     * @param payload {@link UserCreateDto}
     * @return saved {@link UserAllResponseDto}
     */
    UserAllResponseDto saveUser(UserCreateDto payload);

    /**
     * Update one {@link User}.
     *
     * @param payload {@link UserUpdateDto}
     * @return updated {@link UserAllResponseDto}
     */
    UserAllResponseDto updateUser(UserUpdateDto payload);

    /**
     * Delete one {@link User}.
     *
     * @param id {@link Long} user id
     */
    void deleteUser(Long id);

    /**
     * Find all {@link Vehicle}.
     *
     * @param sort {@link String} sort query
     * @return {@link List<VehicleSlimResponseDto>}
     */
    List<VehicleSlimResponseDto> findAllVehicles(String sort);

    /**
     * Find all {@link Vehicle} of one user.
     *
     * @param sort {@link String} sort query
     * @param userId {@link Long} user id
     * @return {@link List<VehicleSlimResponseDto>}
     */
    List<VehicleSlimResponseDto> findAllVehicles(String sort, Long userId);

    /**
     * Find one {@link Vehicle}.
     *
     * @param id {@link Long} vehicle id
     * @return {@link VehicleAllResponseDto}
     */
    VehicleAllResponseDto findVehicleById(Long id);

    /**
     * Save one {@link Vehicle}.
     *
     * @param payload {@link VehicleCreateDto}
     * @param userId {@link Long} user id
     * @return {@link VehicleAllResponseDto}
     */
    VehicleAllResponseDto saveVehicle(VehicleCreateDto payload, Long userId);

    /**
     * Update one {@link Vehicle}.
     *
     * @param payload {@link VehicleUpdateDto}
     * @return {@link VehicleAllResponseDto}
     */
    VehicleAllResponseDto updateVehicle(VehicleUpdateDto payload);

    /**
     * Delete one {@link Vehicle}.
     *
     * @param id {@link Long} vehicle id
     */
    void deleteVehicle(Long id);
}
