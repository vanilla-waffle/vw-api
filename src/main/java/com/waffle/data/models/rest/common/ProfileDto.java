package com.waffle.data.models.rest.common;

import com.waffle.data.models.rest.response.city.CityResponseDto;
import com.waffle.data.models.rest.response.media.ImageResponseDto;
import lombok.Data;

/**
 * Common class for dto classes of Profile.
 */
@Data
public class ProfileDto {

    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private ImageResponseDto picture;
    private CityResponseDto city;
}
