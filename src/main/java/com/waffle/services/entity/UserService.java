package com.waffle.services.entity;


import com.waffle.data.entities.User;
import com.waffle.services.common.BasicService;
import com.waffle.services.common.SortingService;

/**
 * User service.
 */
public interface UserService extends BasicService<User>, SortingService<User> {

    /**
     * Find one {@link User}.
     *
     * @param username {@link String} username
     * @return {@link User}
     */
    User find(String username);
}
