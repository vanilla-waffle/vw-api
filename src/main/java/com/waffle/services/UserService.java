package com.waffle.services;


import com.waffle.data.entity.User;

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
    User save(User payload);

    /**
     * Find user by id.
     *
     * @param id user id
     * @return user
     */
    User find(Long id);

    /**
     * Find user by email.
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
    User update(User payload);

    /**
     * Delete user by id.
     *
     * @param id user id
     */
    void delete(Long id);

    /**
     * Delete user by email.
     *
     * @param email user email
     */
    void delete(String email);

    /**
     * Check whether user exists by id.
     *
     * @param id user id
     * @return check result
     */
    boolean exists(Long id);

    /**
     * Check whether user exists by email.
     *
     * @param email user email
     * @return check result
     */
    boolean exists(String email);
}
