package com.waffle.services;


import com.waffle.dto.UserDto;
import com.waffle.models.entity.User;

import java.util.List;

/**
 * User service.
 */
public interface UserService {

    /**
     * Create a new user.
     *
     * @param payload incoming user data
     * @return created user
     */
    User save(UserDto.Request.Create payload);

    /**
     * Find user by id.
     *
     * @param id user id
     * @return user
     */
    User find(Long id);

    /**
     * Find user by email
     *
     * @param email user email
     * @return user
     */
    User find(String email);

    /**
     * Find all users.
     *
     * @return users
     */
    List<User> findAll();

    /**
     * Update user.
     *
     * @param payload incoming user data
     * @return updated user
     */
    User update(UserDto.Request.Create payload);

    /**
     * Delete user by id.
     *
     * @param id user id
     */
    void delete(Long id);
}
