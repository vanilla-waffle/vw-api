package com.waffle.data.models.rest.common;

import com.waffle.data.constants.types.common.City;
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
    private City city;
}
