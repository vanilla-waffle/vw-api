package com.waffle.controllers;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.dto.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.data.dto.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.services.composite.UserVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

/**
 * Vehicle public controller.
 */
@Api("/public/vehicles")
@RequiredArgsConstructor
public class VehiclePublicController {
    private final UserVehicleService service;

    /**
     * Find all {@link VehicleSlimResponseDto}.
     *
     * @param sort {@link String} sort query
     * @return {@link List<VehicleSlimResponseDto>}
     */
    @GetMapping
    public ResponseEntity<List<VehicleSlimResponseDto>> findAll(@RequestParam(required = false) final String sort) {
        final List<VehicleSlimResponseDto> vehicles = service.findAllVehicles(sort);
        return status(OK).body(vehicles);
    }

    /**
     * Find one {@link VehicleAllResponseDto}.
     *
     * @param id {@link Long} vehicle id
     * @return {@link VehicleAllResponseDto}
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleAllResponseDto> find(@PathVariable @Positive final Long id) {
        final VehicleAllResponseDto response = service.findVehicleById(id);
        return status(OK).body(response);
    }
}
