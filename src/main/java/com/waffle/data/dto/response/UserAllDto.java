package com.waffle.data.dto.response;

import com.waffle.data.dto.common.UserDto;
import java.util.Collection;

/**
 * Response, dto class of User with all information.
 */
public class UserAllDto extends UserDto {
    private Long id;
    private Collection<PostSlimDto> posts;
}