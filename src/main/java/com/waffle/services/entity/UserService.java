package com.waffle.services.entity;


import com.waffle.data.entities.User;
import com.waffle.services.common.*;

/**
 * User service.
 */
public interface UserService extends
        BasicService<User>,
        SortingService<User>,
        SpecificService<User>,
        PagingService<User>,
        FilteringService<User> {

    /**
     * Find one by username.
     *
     * @param username {@link String}
     * @return {@link User}
     */
    User find(String username);
}
