package com.waffle.controllers;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.services.composite.UserPublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

/**
 * Auth public controller.
 */
@Api("/auth")
@RequiredArgsConstructor
public class AuthPublicController {
    private final UserPublicService userPublicService;

    /**
     * Register user.
     *
     * @param payload {@link UserCreateDto}
     * @return {@link UserAllResponseDto}
     */
    @PostMapping("/register")
    public UserAllResponseDto register(@RequestBody @Valid final UserCreateDto payload) {
        return userPublicService.save(payload);
    }
}
