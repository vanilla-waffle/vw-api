package com.waffle.controllers;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.models.rest.request.user.UserUpdateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.entities.User;
import com.waffle.services.composite.UserVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

/**
 * User controller for authorities.
 */
@Api("in/users")
@RequiredArgsConstructor
public class UserController {
    private final UserVehicleService service;

    /**
     * Find one.
     *
     * @param id {@link Long}
     * @return {@link UserAllResponseDto}
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserAllResponseDto> find(@PathVariable @Positive final Long id) {
        final UserAllResponseDto user = service.findUserById(id);
        return status(OK).body(user);
    }

    /**
     * Find one.
     *
     * @param username {@link String}
     * @return {@link UserAllResponseDto}
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<UserAllResponseDto> find(@PathVariable @NotBlank final String username) {
        final UserAllResponseDto user = service.findUserByUsername(username);
        return status(OK).body(user);
    }

    /**
     * Update one {@link User}.
     *
     * @param payload {@link UserUpdateDto}
     * @return {@link UserAllResponseDto}
     */
    @PatchMapping
    public ResponseEntity<UserAllResponseDto> update(@RequestBody @Valid final UserUpdateDto payload) {
        final UserAllResponseDto user = service.updateUser(payload);
        return status(OK).body(user);
    }

    /**
     * Delete one by id.
     *
     * @param id {@link Long} user id
     * @return {@link Boolean} true
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable @Positive final Long id) {
        service.deleteUser(id);
        return status(OK).body(true);
    }
}
