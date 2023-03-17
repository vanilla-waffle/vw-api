package com.waffle.mappers;

import com.waffle.dto.request.UserCreateDto;
import com.waffle.dto.request.UserUpdateDto;
import com.waffle.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Mappers class for mapping {@link com.waffle.models.entity.User} entity.
 */
@Mapper(componentModel = "spring", config = WaffleMapperConfig.class)
public interface UserMapper {

    /**
     * Map from {@link com.waffle.dto.request.UserCreateDto} to {@link User}.
     *
     * @param source user create dto
     * @return user entity
     */
    @Mapping(target = "profile.email", source = "email")
    @Mapping(target = "profile.password", source = "password")
    @Mapping(target = "profile.firstName", source = "firstName")
    @Mapping(target = "profile.lastName", source = "lastName")
    @Mapping(target = "profile.city", source = "city")
    User userCreateDtoToUser(UserCreateDto source);

    /**
     * Compares and directly updates user.
     *
     * @param source user dto
     * @param user   actual user
     */
    void updateUserFromUserUpdateDto(UserUpdateDto source, @MappingTarget User user);
}
