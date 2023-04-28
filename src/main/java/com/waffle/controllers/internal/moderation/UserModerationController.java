package com.waffle.controllers.internal.moderation;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.rest.request.moderation.UserModerationCreateDto;
import com.waffle.data.models.rest.response.moderation.UserModerationAllResponseDto;
import com.waffle.services.composite.UserModerationInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * User moderation controller.
 */
@Api("in/users/mod")
@RequiredArgsConstructor
public class UserModerationController {
    private final UserModerationInternalService userModerationInternalService;

    /**
     * Find all.
     *
     * @param id {@link Long}
     * @param page {@code int}
     * @param size {@code int}
     * @param sort {@link String}
     * @return {@link Page<UserModerationAllResponseDto>}
     */
    @GetMapping("/me")
    public Page<UserModerationAllResponseDto> findAll(
            @Principal final Long id,
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
        return userModerationInternalService.findAll(sort, PageRequest.of(page, size), id);
    }

    /**
     * Find one.
     *
     * @param id {@link Long}
     * @return {@link UserModerationAllResponseDto}
     */
    @GetMapping("/{id}")
    public UserModerationAllResponseDto find(@PathVariable final Long id) {
        return userModerationInternalService.find(id);
    }

    /**
     * Save one.
     *
     * @param id {@link Long}
     * @param payload {@link UserModerationCreateDto}
     * @return {@link UserModerationAllResponseDto}
     */
    @PostMapping("/me")
    public UserModerationAllResponseDto save(
            @Principal final Long id,
            @RequestBody final UserModerationCreateDto payload) {
        payload.setUserId(id);
        return userModerationInternalService.save(payload);
    }
}
