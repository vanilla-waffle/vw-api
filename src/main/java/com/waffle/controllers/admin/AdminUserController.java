package com.waffle.controllers.admin;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.types.user.RoleType;
import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.services.composite.UserInternalService;
import com.waffle.services.composite.UserPublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

/**
 *
 */
@Api("admin/users")
@RequiredArgsConstructor
public class AdminUserController {
    private final UserInternalService userInternalService;
    private final UserPublicService userPublicService;

    /**
     * Find one.
     *
     * @param id {@link Long id}
     * @return {@link UserAllResponseDto}
     */
    @GetMapping("/{id}")
    public UserAllResponseDto find(@PathVariable @Positive final Long id) {
        return userInternalService.find(id);
    }

    /**
     * Find all.
     *
     * @param page {@code int}
     * @param size {@code int}
     * @param sort {@link String}
     * @return {@link Page<UserSlimResponseDto>}
     */
    @GetMapping
    public Page<UserSlimResponseDto> findAll(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
        return userInternalService.findAll(sort, PageRequest.of(page, size));
    }

    /**
     * Create new user.
     *
     * @param payload {@link UserCreateDto}
     * @return {@link UserAllResponseDto}
     */
    @PostMapping
    public UserAllResponseDto save(@RequestBody final UserCreateDto payload) {
        return userPublicService.save(payload);
    }

    /**
     * Grant role.
     *
     * @param id {@link Long}
     * @param role {@link RoleType}
     * @return {@link UserAllResponseDto}
     */
    @PutMapping("/{id}/grant")
    public UserAllResponseDto grant(
            @PathVariable @Positive final Long id,
            @RequestParam final RoleType role) {
        return userInternalService.grant(id, role);
    }

    /**
     * Activate user.
     *
     * @param id {@link Long}
     * @return {@link UserAllResponseDto}
     */
    @PutMapping("/{id}/activate")
    public UserAllResponseDto activate(@PathVariable @Positive final Long id) {
        return userInternalService.activate(id);
    }

    /**
     * Mark user as deleted.
     *
     * @param id {@link Long}
     * @return {@link UserAllResponseDto}
     */
    @DeleteMapping("/{id}")
    public UserAllResponseDto delete(@PathVariable @Positive final Long id) {
        return userInternalService.delete(id);
    }

    /**
     * Delete user from system.
     *
     * @param id {@link Long}
     */
    @DeleteMapping("/{id}/erase")
    public void erase(@PathVariable @Positive final Long id) {
        userInternalService.erase(id);
    }
}
