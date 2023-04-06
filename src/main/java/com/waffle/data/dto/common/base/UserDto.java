package com.waffle.data.dto.common.base;

import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.entities.Authority;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Common class for dto classes of User.
 */
@Data
public class UserDto {

    private Long id;
    private LocalDateTime createdAt;
    private UserStatus status;
    private Set<Authority> authorities;
}
