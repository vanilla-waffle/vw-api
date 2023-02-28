package com.waffle.dto.response;

import com.waffle.model.constants.embedded.Profile;
import com.waffle.model.constants.types.Status;
import com.waffle.model.entity.Post;

import java.time.LocalDateTime;
import java.util.Collection;

public class UserDto {
    private Long id;
    private LocalDateTime createdAt;
    private Status status;
    private Profile profile;
    private Collection<Post> posts;
}
