package com.waffle.dto.request;

import com.waffle.model.constants.types.City;

/**
 * Request, dto class to create a User.
 */
public class UserCreateDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private City city;
}
