package com.waffle.data.dto.request;

import com.waffle.data.constants.annotations.Password;
import com.waffle.data.constants.types.common.City;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Request, dto class to create a User.
 */
@Data
public class UserCreateDto {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Password
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotNull
    private City city;
}
