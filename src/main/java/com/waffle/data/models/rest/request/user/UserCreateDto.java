package com.waffle.data.models.rest.request.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.data.constants.annotations.spring.Email;
import com.waffle.data.constants.annotations.validation.Password;
import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.models.rest.common.ProfileDto;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Request, dto class to create a User.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserCreateDto extends ProfileDto {

    @NotNull
    @Password
    private String password;

    @JsonIgnore
    private MultipartFile media;

    @Override
    @Email
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    @NotNull
    @Size(max = TextSize.XS)
    public String getUsername() {
        return super.getUsername();
    }
}
