package com.waffle.controllers.admin.moderation;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.rest.response.moderation.UserModerationAllResponseDto;
import com.waffle.services.composite.UserModerationInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Admin user moderation controller.
 */
@Api("admin/users/mod")
@RequiredArgsConstructor
public class AdminUserModerationController {
    private final UserModerationInternalService userModerationInternalService;

    /**
     * Find all.
     *
     * @param page {@code int}
     * @param size {@code int}
     * @param sort {@link String}
     * @return {@link Page<UserModerationAllResponseDto>}
     */
    @GetMapping
    public Page<UserModerationAllResponseDto> findAll(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
        return userModerationInternalService.findAll(sort, PageRequest.of(page, size));
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
     * Approve.
     *
     * @param adminId {@link Long}
     * @param id {@link Long}
     * @return {@link UserModerationAllResponseDto}
     */
    @PutMapping("/{id}/approve")
    public UserModerationAllResponseDto approve(
            @Principal final Long adminId,
            @PathVariable final Long id) {
        return userModerationInternalService.approve(id, adminId);
    }

    /**
     * Reject.
     *
     * @param adminId {@link Long}
     * @param id {@link Long}
     * @param message {@link String}
     * @return {@link UserModerationAllResponseDto}
     */
    @PutMapping("/{id}/reject")
    public UserModerationAllResponseDto reject(
            @Principal final Long adminId,
            @PathVariable final Long id,
            @RequestParam(defaultValue = "Rejected") final String message) {
        return userModerationInternalService.reject(id, adminId, message);
    }

    /**
     * Delete.
     *
     * @param adminId {@link Long}
     * @param id {@link Long}
     * @return {@link UserModerationAllResponseDto}
     */
    @DeleteMapping("/{id}")
    public UserModerationAllResponseDto delete(
            @Principal final Long adminId,
            @PathVariable final Long id) {
        return userModerationInternalService.delete(id, adminId);
    }

    /**
     * Erase.
     *
     * @param id {@link Long}
     */
    @DeleteMapping("/{id}/erase")
    public void erase(@PathVariable final Long id) {
        userModerationInternalService.erase(id);
    }
}
