package com.waffle.service;

import com.waffle.entity.User;

/**
 * User service.
 */
public interface UserService {

    /**
     * Create a new user.
     *
     * @param user incoming user data
     * @return created user
     */
    User save(User user);

    /**
     * Find user by id.
     *
     * @param id user id
     * @return user
     */
    User find(Long id);

    /**
     * Find all users.
     *
     * @return users
     */
    Iterable<User> findAll();

    /**
     * Update user.
     *
     * @param user incoming user data
     * @return updated user
     */
    User update(User user);

    /**
     * Delete user by id.
     *
     * @param id user id
     */
    void delete(Long id);
}
