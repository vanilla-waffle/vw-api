package com.waffle.controllers;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserPublicResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.services.composite.UserVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

/**
 * User public controller.
 */
@Api("public/users")
@RequiredArgsConstructor
public class UserPublicController {
    private final UserVehicleService service;

    /**
     * Find all {@link UserPublicResponseDto}.
     *
     * @param sort {@link String}
     * @return {@link List<UserPublicResponseDto>}
     */
    @GetMapping
    public ResponseEntity<List<UserPublicResponseDto>> findAll(@RequestParam(required = false) final String sort) {
        final List<UserPublicResponseDto> users = service.findAllPublicUsers(sort);
        return status(OK).body(users);
    }

    /**
     * Find all {@link VehicleAllResponseDto}.
     *
     * @param userId {@link Long} user id
     * @param sort {@link String} sort query
     * @return {@link List<VehicleSlimResponseDto>}
     */
    @GetMapping("/{userId}/vehicles")
    public ResponseEntity<List<VehicleSlimResponseDto>> findAll(
            @PathVariable @Positive final Long userId,
            @RequestParam(required = false) final String sort) {
        final List<VehicleSlimResponseDto> response = service.findAllVehicles(sort, userId);
        return status(OK).body(response);
    }

    /**
     * Save one.
     *
     * @param payload {@link UserCreateDto}
     * @return {@link UserAllResponseDto}
     */
    @PostMapping
    public ResponseEntity<UserAllResponseDto> save(@RequestBody @Valid final UserCreateDto payload) {
        final UserAllResponseDto user = service.saveUser(payload);
        return status(CREATED).body(user);
    }
}
