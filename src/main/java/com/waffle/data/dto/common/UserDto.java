package com.waffle.data.dto.common;

import com.waffle.data.dto.response.ProfileSlimDto;
import com.waffle.data.constants.types.Status;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * Common class for dto classes of User.
 */
@Data
@SuperBuilder
public class UserDto {
    private LocalDateTime createdAt;
    private Status status;
    private ProfileSlimDto profile;
}
