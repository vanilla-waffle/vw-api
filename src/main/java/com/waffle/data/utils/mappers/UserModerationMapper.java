package com.waffle.data.utils.mappers;

import com.waffle.configurations.MapperConfiguration;
import com.waffle.data.entities.admin.UserModeration;
import com.waffle.data.models.rest.request.moderation.UserModerationCreateDto;
import com.waffle.data.models.rest.response.moderation.UserModerationAllResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapperConfiguration.class)
public interface UserModerationMapper {

    /**
     * Map from {@link UserModerationCreateDto} to {@link UserModeration}.
     *
     * @param source {@link UserModerationCreateDto}
     * @return {@link UserModeration}
     */
    UserModeration convert(UserModerationCreateDto source);

    /**
     * Map from {@link UserModeration} to {@link UserModerationAllResponseDto}.
     *
     * @param source {@link UserModeration}
     * @return {@link UserModerationAllResponseDto}
     */
    UserModerationAllResponseDto convertAll(UserModeration source);
}
