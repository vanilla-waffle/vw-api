package com.waffle.services.entity;


import com.waffle.data.entities.User;
import com.waffle.services.common.BasicService;
import com.waffle.services.common.SortingService;
import com.waffle.services.common.SpecificService;

/**
 * User service.
 */
public interface UserService extends BasicService<User>, SortingService<User>, SpecificService<User> {
}
