package com.waffle.services.entity;


import com.waffle.data.entities.User;
import com.waffle.services.common.BasicService;
import com.waffle.services.common.SortingService;

/**
 * User service.
 */
public interface UserService extends BasicService<User>, SortingService<User> {
}
