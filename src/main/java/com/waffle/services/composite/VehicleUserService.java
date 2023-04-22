package com.waffle.services.composite;

import com.waffle.data.models.rest.request.vehicle.VehicleCreateDto;
import com.waffle.data.models.rest.request.vehicle.VehicleUpdateDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.data.entities.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * User vehicle service.
 */
public interface VehicleUserService {

    /**
     * Find all.
     *
     * @param query {@link String} sort query
     * @return {@link List<VehicleSlimResponseDto>}
     */
    List<VehicleSlimResponseDto> findAll(String query);

    /**
     * Find all.
     *
     * @param query {@link String} sort query
     * @param userId {@link Long} user id
     * @return {@link List<VehicleSlimResponseDto>}
     */
    List<VehicleSlimResponseDto> findAll(String query, Long userId);

    /**
     * Find all.
     *
     * @param query {@link String}
     * @param userId {@link Long}
     * @param page {@link PageRequest}
     * @return {@link Page<VehicleSlimResponseDto>}
     */
    Page<VehicleSlimResponseDto> findAll(String query, Long userId, PageRequest page);

    /**
     * Find all.
     *
     * @param query {@link String}
     * @param page {@link PageRequest}
     * @return {@link Page<VehicleSlimResponseDto>}
     */
    Page<VehicleSlimResponseDto> findAll(String query, PageRequest page);

    /**
     * Find one {@link Vehicle}.
     *
     * @param id {@link Long} vehicle id
     * @return {@link VehicleAllResponseDto}
     */
    VehicleAllResponseDto find(Long id);

    /**
     * Save one {@link Vehicle}.
     *
     * @param payload {@link VehicleCreateDto}
     * @param userId {@link Long} user id
     * @return {@link VehicleAllResponseDto}
     */
    VehicleAllResponseDto save(VehicleCreateDto payload, Long userId);

    /**
     * Update one {@link Vehicle}.
     *
     * @param payload {@link VehicleUpdateDto}
     * @return {@link VehicleAllResponseDto}
     */
    VehicleAllResponseDto update(VehicleUpdateDto payload);

    /**
     * Delete one {@link Vehicle}.
     *
     * @param id {@link Long} vehicle id
     */
    void delete(Long id);
}
