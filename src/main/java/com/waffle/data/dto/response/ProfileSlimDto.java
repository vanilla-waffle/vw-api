package com.waffle.data.dto.response;

import com.waffle.data.constants.types.common.City;
import lombok.Data;

/**
 * Response, dto class of Profile with slim information.
 */
@Data
public class ProfileSlimDto {
    private String email;
    private String firstName;
    private String lastName;
    private City city;
}
