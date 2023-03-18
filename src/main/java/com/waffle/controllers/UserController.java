package com.waffle.controllers;

import com.waffle.data.dto.request.UserCreateDto;
import com.waffle.data.dto.request.UserUpdateDto;
import com.waffle.data.dto.response.UserAllDto;
import com.waffle.data.dto.response.UserSlimDto;
import com.waffle.data.entity.User;
import com.waffle.mappers.UserMapper;
import com.waffle.services.GeneralService;
import com.waffle.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

/**
 * User controller.
 */
@RestController("user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final GeneralService generalService;
    private final UserService userService;
    private final UserMapper mapper;

    /**
     * Save new user.
     *
     * @param user request body
     * @return slim response dto
     */
    @PostMapping
    public ResponseEntity<UserSlimDto> save(@RequestBody final UserCreateDto user) {
        log.info("[SAVE] Request to save user {} {} {}", user.getEmail(), user.getFirstName(), user.getLastName());
        final UserSlimDto response = generalService.save(user);
        return status(CREATED).body(response);
    }

    /**
     * Delete existing user.
     *
     * @param id user id
     * @return success message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable final Long id) {
        log.info("[DELETE:id] Request to delete user with id {}", id);
        generalService.delete(id);
        final String message = String.format("OK. User {%s} was deleted.", id.toString());
        return status(OK).body(message);
    }

    /**
     * Update existing user.
     *
     * @param user user
     * @return all response dto
     */
    @PutMapping
    public ResponseEntity<UserAllDto> update(@RequestBody final UserUpdateDto user) {
        log.info("[UPDATE] Request to update user with email {}", user.getProfile().getEmail());
        final UserAllDto response = generalService.update(user);
        return status(OK).body(response);
    }

    /**
     * Find all users.
     *
     * @deprecated Method is designed for development purposes. It should be excluded in future releases.
     * @return all response dto list
     */
    @GetMapping
    @Deprecated
    public ResponseEntity<List<UserAllDto>> find() {
        final List<User> users = userService.findAll();
        final List<UserAllDto> response = mapper.fromUserToAllDto(users);
        return status(OK).body(response);
    }

    /**
     * Find user by id.
     *
     * @param id user id
     * @return all response sto
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<UserAllDto> find(@PathVariable final Long id) {
        log.info("[FIND:id] Request to find user with id {}", id);
        final User user = userService.find(id);
        final UserAllDto response = mapper.fromUserToAllDto(user);
        return status(OK).body(response);
    }

    /**
     * Find user by id.
     *
     * @param email user email
     * @return all response sto
     */
    @GetMapping("/{email}")
    public ResponseEntity<UserAllDto> find(@PathVariable final String email) {
        log.info("[FIND:email] Request to find user with email {}", email);
        final User user = userService.find(email);
        final UserAllDto response = mapper.fromUserToAllDto(user);
        return status(OK).body(response);
    }

    /**
     * Find user by pre-defined query.
     *
     * @param q query body
     * @return all response dto
     */
    @GetMapping("/by")
    public ResponseEntity<UserAllDto> findBy(@RequestParam final String q) {
        throw new NotYetImplementedException("Sorry. This method is under development.");
    }
}
