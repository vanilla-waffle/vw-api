package com.waffle.data.dto.request.user;

import com.waffle.data.constants.annotations.Password;
import com.waffle.data.constants.types.common.TextSize;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Request, dto class to create a User.
 */
@Data
public class UserCreateDto {

    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(max = TextSize.XS)
    private String username;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    @Password
    private String password;
}
