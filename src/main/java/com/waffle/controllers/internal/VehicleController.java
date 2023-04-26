package com.waffle.controllers.internal;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.models.rest.request.vehicle.VehicleCreateDto;
import com.waffle.data.models.rest.request.vehicle.VehicleUpdateDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.services.composite.VehicleInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

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
     * @param payload {@link VehicleCreateDto}
     * @return {@link VehicleAllResponseDto}
     */
    @PostMapping
    @ResponseStatus(CREATED)
    public VehicleAllResponseDto save(@RequestBody @Valid final VehicleCreateDto payload) {
        return service.save(payload, payload.getUserId());
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
