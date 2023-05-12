package com.waffle.controllers.internal;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.rest.request.vehicle.VehicleCreateDto;
import com.waffle.data.models.rest.request.vehicle.VehicleUpdateDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.services.composite.internal.VehicleInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Vehicle controller.
 */
@Api("in/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleInternalService service;

    /**
     * Save one.
     *
     * @param userId {@link Long}
     * @param payload {@link VehicleCreateDto}
     * @param file array of {@link MultipartFile}
     * @return {@link VehicleAllResponseDto}
     */
    @PostMapping
    @ResponseStatus(CREATED)
    public VehicleAllResponseDto save(
            @Principal final Long userId,
            @RequestPart("vehicle") @Valid final VehicleCreateDto payload,
            @RequestPart final MultipartFile[] file) {
        payload.setUserId(userId);
        return service.save(payload, payload.getUserId(), List.of(file));
    }

    /**
     * Update one.
     *
     * @param payload {@link VehicleUpdateDto}
     * @return {@link VehicleAllResponseDto}
     */
    @PatchMapping
    public VehicleAllResponseDto update(@RequestBody @Valid final VehicleUpdateDto payload) {
        return service.update(payload);
    }

    /**
     * Delete one.
     *
     * @param id {@link Long} vehicle id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Positive final Long id) {
        service.delete(id);
    }
}
