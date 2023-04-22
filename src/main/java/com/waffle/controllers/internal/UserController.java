package com.waffle.controllers.internal;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.rest.request.user.UserUpdateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.services.composite.UserInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

/**
 * User controller for authorities.
 */
@Api("in/users")
@RequiredArgsConstructor
public class UserController {
    private final UserInternalService userInternalService;

//    /**
//     * Find one.
//     *
//     * @param id {@link Long}
//     * @return {@link UserAllResponseDto}
//     */
//    @GetMapping("/{id}")
//    @Deprecated
//    public ResponseEntity<UserAllResponseDto> findById(@PathVariable @Positive final Long id) {
//        final UserAllResponseDto user = userInternalService.find(id);
//        return status(OK).body(user);
//    }

    /**
     * Find one.
     *
     * @param id {@link Long}
     * @return {@link UserAllResponseDto}
     */
    @GetMapping("/me")
    public ResponseEntity<UserAllResponseDto> find(@Principal final Long id) {
        final UserAllResponseDto user = userInternalService.find(id);
        return status(OK).body(user);
    }

    /**
     * Update one.
     *
     * @param id {@link Long}
     * @param payload {@link UserUpdateDto}
     * @return {@link UserAllResponseDto}
     */
    @PatchMapping("/me")
    public ResponseEntity<UserAllResponseDto> update(
            @Principal final Long id,
            @RequestBody @Valid final UserUpdateDto payload
    ) {
        payload.setId(id);
        final UserAllResponseDto user = userInternalService.update(payload);
        return status(OK).body(user);
    }

    /**
     * Delete one.
     *
     * @param id {@link Long} user id
     */
    @DeleteMapping("/me")
    public void delete(@Principal final Long id) {
        userInternalService.delete(id);
    }
}
