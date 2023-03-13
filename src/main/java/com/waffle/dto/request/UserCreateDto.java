package com.waffle.dto.request;

import com.waffle.models.constants.types.City;
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
