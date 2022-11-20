package com.waffle.controller;

import com.waffle.dto.UserDto;
import com.waffle.entity.User;
import com.waffle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * User controller.
 */
@SuppressWarnings({"checkstyle:MissingJavadocMethod", "checkstyle:DesignForExtension"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> save(@Validated @RequestBody final UserDto.Request.Create user) {
        return new ResponseEntity<>(
                userService.save(new User(null, user.getProfile(), null)),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(
                userService.findAll(),
                HttpStatus.OK
        );
    }
}
