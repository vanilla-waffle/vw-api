package com.waffle.data.models.rest.request.user;

import com.waffle.data.constants.annotations.spring.Email;
import com.waffle.data.constants.annotations.validation.Password;
import com.waffle.data.constants.annotations.validation.Phone;
import com.waffle.data.constants.types.common.TextSize;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Request, dto class to create a User.
 */
@Data
@Builder
public class UserCreateDto {

    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(max = TextSize.XS)
    private String username;
    @Phone
    private String phoneNumber;
    @NotEmpty
    @Password
    private String password;
}
