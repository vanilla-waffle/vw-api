package com.waffle.data.dto.request.user;

import com.waffle.data.constants.annotations.validation.Password;
import com.waffle.data.constants.annotations.validation.Phone;
import com.waffle.data.constants.types.common.City;
import com.waffle.data.constants.types.common.TextSize;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
//    @Phone
    private String phoneNumber;
    @NotNull
    private City city;
    @NotEmpty
//    @Password
    private String password;
}
