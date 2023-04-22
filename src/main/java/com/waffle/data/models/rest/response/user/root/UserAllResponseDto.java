package com.waffle.data.models.rest.response.user.root;

import com.waffle.data.models.rest.common.RoleDto;
import com.waffle.data.models.rest.common.UserDto;
import com.waffle.data.models.rest.response.user.root.profile.ProfileAllResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * Response, dto class of User with all information.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserAllResponseDto extends UserDto {

    private Set<RoleDto> roles;
    private ProfileAllResponseDto profile;
}

