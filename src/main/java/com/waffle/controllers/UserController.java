package com.waffle.controllers;

import com.waffle.data.dto.other.SearchCriteria;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

/**
 * User controller.
 */
@RestController
@RequestMapping("users")
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
    public ResponseEntity<UserSlimDto> save(@RequestBody @Valid final UserCreateDto user) {
        log.info("[SAVE] Request to save user: {} {} {}", user.getEmail(), user.getFirstName(), user.getLastName());
        final UserSlimDto response = generalService.save(user);
        return status(CREATED).body(response);
    }

    /**
     * Find user by id.
     *
     * @param id user id
     * @return all response sto
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserAllDto> find(@PathVariable @NotNull final Long id) {
        log.info("[FIND:id] Request to find user with id: {}", id);
        final User user = userService.find(id);
        final UserAllDto response = mapper.fromUserToAllDto(user);
        return status(OK).body(response);
    }

    /**
     * Find user by pre-defined query.
     *
     * @param q query body
     * @return all response dto
     */
    @GetMapping("/search")
    public ResponseEntity<UserAllDto> find(@RequestParam @NotNull final String q) {
        log.info("[FIND:search] Request to find user with query: {}", q);
        final SearchCriteria criteria = SearchCriteria.from(q);
        final User user = userService.find(criteria);
        final UserAllDto response = mapper.fromUserToAllDto(user);
        return status(OK).body(response);
    }

    /**
     * Find users by pre-defined query.
     *
     * @param q query body
     * @return all response dto list
     */
    @GetMapping("/search-all")
    public ResponseEntity<List<UserAllDto>> findAll(@RequestParam final String q) {
        log.info("[FIND:search-all] Request to find user with query: {}", q);
        final SearchCriteria criteria = SearchCriteria.from(q);
        final List<User> users = userService.findAll(criteria);
        final List<UserAllDto> response = mapper.fromUserToAllDto(users);
        return status(OK).body(response);
    }

    /**
     * Delete existing user.
     *
     * @param id user id
     * @return success message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable final Long id) {
        log.info("[DELETE:id] Request to delete user with id: {}", id);
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
        log.info("[UPDATE] Request to update user with email: {}", user.getProfile().getEmail());
        final UserAllDto response = generalService.update(user);
        return status(OK).body(response);
    }
}
