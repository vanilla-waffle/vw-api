package com.waffle.data.dto.request;

import com.waffle.data.constants.types.City;
import lombok.*;

/**
 * Request, dto class to create a User.
 */
@Data
public class UserCreateDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private City city;
}
