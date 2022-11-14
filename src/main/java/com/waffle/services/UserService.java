package com.waffle.services;

import com.waffle.entity.User;

import java.util.List;

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
    List<User> findAll();

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
