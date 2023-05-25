package com.waffle.controllers;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.NonDocumented;
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
import java.util.HashMap;
import java.util.Map;

@Api("/public/vehicles")
@RequiredArgsConstructor
public class VehiclePublicController {
    private final VehicleInternalService service;

    @GetMapping
    @NonDocumented
    @SuppressWarnings("checkstyle:ParameterNumber")
    public Page<VehicleSlimResponseDto> findAll(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort,
            @RequestParam(required = false) final String title,
            @RequestParam(required = false) final String city,
            @RequestParam(required = false) final String manuf,
            @RequestParam(required = false) final String model,
            @RequestParam(required = false) final String year) {
        final Map<String, String> params = new HashMap<>();

        if (title != null) {
            params.put("title", title);
        }

        if (city != null) {
            params.put("location.city.name", city);
        }

        if (manuf != null) {
            params.put("manuf", manuf);
        }

        if (model != null) {
            params.put("model", model);
        }

        if (year != null) {
            params.put("release_year", year);
        }

        return service.findAll(sort, PageRequest.of(page, size), params);
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
