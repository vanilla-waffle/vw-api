package com.waffle.controllers;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.models.rest.response.user.root.UserPublicResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.services.composite.UserPublicService;
import com.waffle.services.composite.VehicleUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

/**
 * User public controller.
 */
@Api("public/users")
@RequiredArgsConstructor
public class UserPublicController {
    private final UserPublicService userPublicService;
    private final VehicleUserService vehicleUserService;

    /**
     * Find all.
     *
     * @param page {@code int}
     * @param size {@code size}
     * @param sort {@link String}
     * @return {@link Page<UserPublicResponseDto>}
     */
    @GetMapping
    public ResponseEntity<Page<UserPublicResponseDto>> findAll(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
        final Page<UserPublicResponseDto> users = userPublicService.findAll(sort, PageRequest.of(page, size));
        return status(OK).body(users);
    }

    /**
     * Find all.
     *
     * @param userId {@link Long}
     * @param page {@code int}
     * @param size {@code int}
     * @param sort {@link String}
     * @return {@link Page<VehicleSlimResponseDto>}
     */
    @GetMapping("/{userId}/vehicles")
    public ResponseEntity<Page<VehicleSlimResponseDto>> findAll(
            @PathVariable @Positive final Long userId,
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "10") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
        final Page<VehicleSlimResponseDto> response = vehicleUserService.findAll(sort, userId, PageRequest.of(page, size));
        return status(OK).body(response);
    }
}
