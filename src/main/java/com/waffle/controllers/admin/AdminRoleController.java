package com.waffle.controllers.admin;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.types.user.RoleType;
import com.waffle.data.models.rest.response.user.role.RoleResponseAllDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.services.composite.internal.RoleManagementInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Admin role controller.
 */
@Api("admin/roles")
@RequiredArgsConstructor
public class AdminRoleController {
    private final RoleManagementInternalService roleManagementInternalService;

    /**
     * Find all.
     *
     * @param page {@code int}
     * @param size {@code int}
     * @param sort {@link String}
     * @return {@link Page<RoleResponseAllDto>}
     */
    @GetMapping
    public Page<RoleResponseAllDto> findAll(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
        return roleManagementInternalService.findAll(sort, PageRequest.of(page, size));
    }

    /**
     * Assign role.
     *
     * @param userId {@link Long}
     * @param role {@link RoleType}
     * @return {@link UserAllResponseDto}
     */
    @PutMapping("/{userId}/promote")
    public UserAllResponseDto promote(
            @PathVariable final Long userId,
            @RequestParam(defaultValue = "ADMIN") final RoleType role) {
        return roleManagementInternalService.promote(userId, role);
    }

    /**
     * Take away role.
     *
     * @param userId {@link Long}
     * @param role {@link RoleType}
     * @return {@link UserAllResponseDto}
     */
    @PutMapping("/{userId}/demote")
    public UserAllResponseDto demote(
            @PathVariable final Long userId,
            @RequestParam(defaultValue = "ADMIN") final RoleType role) {
        return roleManagementInternalService.demote(userId, role);
    }

    /**
     * Delete role.
     *
     * @param id {@link Long}
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) {
        roleManagementInternalService.delete(id);
    }
}
