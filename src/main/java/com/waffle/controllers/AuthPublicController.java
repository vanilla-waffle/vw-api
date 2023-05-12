package com.waffle.controllers;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.services.composite.open.UserPublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Api("/auth")
@RequiredArgsConstructor
public class AuthPublicController {
    private final UserPublicService userPublicService;

    /**
     * Register user.
     *
     * @param payload {@link UserCreateDto}
     * @param file {@link MultipartFile}
     * @return {@link UserAllResponseDto}
     */
    @PostMapping("/register")
    public UserAllResponseDto register(
            @RequestPart("user") @Valid final UserCreateDto payload,
            @RequestPart(name = "file", required = false) final MultipartFile file) {
        return userPublicService.save(payload, file);
    }
}
