package com.waffle.dto.common;

import com.waffle.dto.response.ProfileSlimDto;
import com.waffle.model.constants.types.Status;

import java.time.LocalDateTime;

/**
 * Common class for dto classes of User.
 */
public class UserDto {
    private LocalDateTime createdAt;
    private Status status;
    private ProfileSlimDto profile;
}
