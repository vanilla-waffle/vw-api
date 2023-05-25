package com.waffle.services.composite.internal;

import com.waffle.data.constants.annotations.spring.NonDocumented;
import com.waffle.data.models.rest.request.vehicle.VehicleCreateDto;
import com.waffle.data.models.rest.request.vehicle.VehicleUpdateDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.data.entities.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * User vehicle service.
 */
public interface VehicleInternalService {

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

    @NonDocumented
    Page<VehicleSlimResponseDto> findAll(String query, PageRequest page, Map<String, String> params);

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
     * @param userId  {@link Long} user id
     * @param files {@link List} of {@link MultipartFile}
     * @return {@link VehicleAllResponseDto}
     */
    VehicleAllResponseDto save(VehicleCreateDto payload, Long userId, List<MultipartFile> files);

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
