package com.waffle.controllers.internal;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.models.rest.request.vehicle.VehicleCreateDto;
import com.waffle.data.models.rest.request.vehicle.VehicleUpdateDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.services.composite.VehicleUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

/**
 * Vehicle controller.
 */
@Api("in/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleUserService service;

    /**
     * Save one.
     *
     * @param payload {@link VehicleCreateDto}
     * @return {@link VehicleAllResponseDto}
     */
    @PostMapping
    public ResponseEntity<VehicleAllResponseDto> save(@RequestBody @NotNull @Valid final VehicleCreateDto payload) {
        final VehicleAllResponseDto vehicle = service.save(payload, payload.getUserId());
        return status(CREATED).body(vehicle);
    }

    /**
     * Update one.
     *
     * @param payload {@link VehicleUpdateDto}
     * @return {@link VehicleAllResponseDto}
     */
    @PatchMapping
    public ResponseEntity<VehicleAllResponseDto> update(@RequestBody @Valid final VehicleUpdateDto payload) {
        VehicleAllResponseDto vehicle = service.update(payload);
        return status(OK).body(vehicle);
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
