package com.waffle.data.models.rest.request.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.data.constants.annotations.spring.Email;
import com.waffle.data.constants.annotations.validation.Password;
import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.models.rest.common.ProfileDto;
import com.waffle.data.models.rest.response.city.CityResponseDto;
import com.waffle.data.models.rest.response.image.ImageResponseDto;
import lombok.*;

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

    @Override
    @JsonIgnore
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    @JsonIgnore
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    @JsonIgnore
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    @JsonIgnore
    public CityResponseDto getCity() {
        return super.getCity();
    }

    @Override
    @JsonIgnore
    public ImageResponseDto getImage() {
        return super.getImage();
    }
}
