package com.waffle.data.models.rest.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.waffle.data.constants.types.user.UserStatus;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Common class for dto classes of User.
 */
@Data
public class UserDto {

    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm")
    private LocalDateTime createdAt;
    private UserStatus status;
}
