package com.waffle.data.models.rest.common.root;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.entities.Role;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

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
