package com.waffle.data.dto.common;

import com.waffle.data.constants.types.common.City;
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
