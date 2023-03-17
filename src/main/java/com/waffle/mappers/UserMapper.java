package com.waffle.mappers;

import com.waffle.data.dto.request.UserCreateDto;
import com.waffle.data.dto.response.UserAllDto;
import com.waffle.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mappers class for mapping {@link com.waffle.data.entity.User} entity.
 */
@Mapper(componentModel = "spring", config = WaffleMapperConfig.class)
public interface UserMapper {

    /**
     * Map from {@link UserCreateDto} to {@link User}.
     *
     * @param source user create dto
     * @return user entity
     */
    @Mapping(target = "profile.email", source = "email")
    @Mapping(target = "profile.password", source = "password")
    @Mapping(target = "profile.firstName", source = "firstName")
    @Mapping(target = "profile.lastName", source = "lastName")
    @Mapping(target = "profile.city", source = "city")
    User createDtoToUser(UserCreateDto source);

    /**
     * Map from {@link User} to {@link UserAllDto}.
     *
     * @param source user
     * @return all response dto
     */
    @Mapping(target = "profile.email", source = "profile.email")
    @Mapping(target = "profile.firstName", source = "profile.firstName")
    @Mapping(target = "profile.lastName", source = "profile.lastName")
    @Mapping(target = "profile.city", source = "profile.city")
    UserAllDto userToAllDto(User source);
}
