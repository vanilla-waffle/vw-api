package com.waffle.controllers.admin;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.services.composite.internal.UserInternalService;
import com.waffle.services.composite.open.UserPublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Positive;

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
     * @param file {@link MultipartFile}
     * @return {@link UserAllResponseDto}
     */
    @PostMapping
    public UserAllResponseDto save(
            @RequestPart("user") final UserCreateDto payload,
            @RequestPart(name = "media", required = false) final MultipartFile file) {
        return userPublicService.save(payload, file);
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
