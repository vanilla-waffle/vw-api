package com.waffle.data.models.rest.response.user.root;

import com.waffle.data.entities.Role;
import com.waffle.data.models.rest.common.root.UserDto;
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

    private Set<Role> roles;
    private ProfileAllResponseDto profile;
}

