package com.waffle.controllers;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.models.rest.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.services.composite.internal.VehicleInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;

@Api("/public/vehicles")
@RequiredArgsConstructor
public class VehiclePublicController {
    private final VehicleInternalService service;

    /**
     * Find all.
     *
     * @param page {@code int}
     * @param size {@code int}
     * @param sort {@link String} sort query
     * @return {@link Page<VehicleSlimResponseDto>}
     */
    @GetMapping
    public Page<VehicleSlimResponseDto> findAll(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
        return service.findAll(sort, PageRequest.of(page, size));
    }

    /**
     * Find one.
     *
     * @param id {@link Long} vehicle id
     * @return {@link VehicleAllResponseDto}
     */
    @GetMapping("/{id}")
    public VehicleAllResponseDto find(@PathVariable @Positive final Long id) {
        return service.find(id);
    }
}
