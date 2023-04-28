package com.waffle.controllers.internal;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.rest.request.user.UserUpdateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.services.composite.UserInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * User controller for authorities.
 */
@Api("in/users/me")
@RequiredArgsConstructor
public class UserController {
    private final UserInternalService userInternalService;

    /**
     * Find one.
     *
     * @param id {@link Long}
     * @return {@link UserAllResponseDto}
     */
    @GetMapping
    public UserAllResponseDto find(@Principal final Long id) {
        return userInternalService.find(id);
    }

    /**
     * Update one.
     *
     * @param id {@link Long}
     * @param payload {@link UserUpdateDto}
     * @return {@link UserAllResponseDto}
     */
    @PatchMapping
    public UserAllResponseDto update(
            @Principal final Long id,
            @RequestBody @Valid final UserUpdateDto payload) {
        payload.setId(id);
        return userInternalService.update(payload);
    }

    /**
     * Delete one.
     *
     * @param id {@link Long} user id
     */
    @DeleteMapping
    public void delete(@Principal final Long id) {
        userInternalService.delete(id);
    }
}
