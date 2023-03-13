package com.waffle.dto.common;

import com.waffle.models.constants.types.City;
import lombok.Data;

/**
 * Common class for dto classes of Profile.
 */
@Data
public class ProfileDto {
    private String email;
    private String firstName;
    private String lastName;
    private City city;
}
