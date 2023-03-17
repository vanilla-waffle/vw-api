package com.waffle.controllers;

import com.waffle.data.dto.request.UserCreateDto;
import com.waffle.data.dto.response.UserAllDto;
import com.waffle.data.dto.response.UserSlimDto;
import com.waffle.data.entity.User;
import com.waffle.services.GeneralService;
import com.waffle.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * User controller.
 */
@RestController("user")
@RequiredArgsConstructor
public class UserController {
    private final GeneralService generalService;
    private final UserService userService;

    /**
     * Save new user.
     *
     * @param user request body
     * @return slim response dto
     */
    @PostMapping
    public ResponseEntity<UserSlimDto> save(@RequestBody final UserCreateDto user) {
        final UserSlimDto response = generalService.save(user);
        return ResponseEntity.status(CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserAllDto> find(@PathVariable final Long userId) {
        final User user = userService.find(userId);
        return null;
    }
}
