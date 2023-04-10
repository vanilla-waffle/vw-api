package com.waffle.data.mappers;

import com.waffle.configurations.MapperConfiguration;
import com.waffle.data.models.rest.request.user.UserCreateDto;
import com.waffle.data.models.rest.request.user.UserUpdateDto;
import com.waffle.data.models.rest.response.user.root.UserAllResponseDto;
import com.waffle.data.models.rest.response.user.root.UserPublicResponseDto;
import com.waffle.data.models.rest.response.user.root.UserSlimResponseDto;
import com.waffle.data.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Mappers class for mapping {@link com.waffle.data.entities.User} entity.
 */
@Mapper(componentModel = "spring", config = MapperConfiguration.class)
public interface UserMapper {

    /**
     * Merge two {@link User} into one instance. Ignores null-values from source.
     *
     * @param source {@link User}
     * @param target {@link User}
     * @return merged {@link User}
     */
    @Mapping(target = "profile.email", source = "profile.email")
    User update(User source, @MappingTarget User target);

    /**
     * Map from {@link UserCreateDto} to {@link User}.
     *
     * @param source {@link UserCreateDto}
     * @return {@link User}
     */
    @Mapping(target = "profile.email", source = "email")
    @Mapping(target = "profile.username", source = "username")
    @Mapping(target = "profile.password", source = "password")
    @Mapping(target = "profile.phoneNumber", source = "phoneNumber")
    @Mapping(target = "profile.city", source = "city")
    User convert(UserCreateDto source);

    /**
     * Map from {@link UserUpdateDto} to {@link User}.
     *
     * @param source {@link UserUpdateDto}
     * @return {@link User}
     */
    User convert(UserUpdateDto source);

    /**
     * Map from {@link User} to {@link UserPublicResponseDto}.
     *
     * @param source {@link User}
     * @return {@link UserPublicResponseDto}
     */
    UserPublicResponseDto convertPublic(User source);

    /**
     * Map list of {@link User} to {@link UserPublicResponseDto}.
     *
     * @param source list of {@link User}
     * @return list of {@link UserPublicResponseDto}
     */
    List<UserPublicResponseDto> convertPublic(List<User> source);

    /**
     * Map from {@link User} to {@link UserAllResponseDto}.
     *
     * @param source {@link User}
     * @return {@link UserAllResponseDto}
     */
    UserAllResponseDto convertAll(User source);

    /**
     * Map list of {@link User} to {@link UserAllResponseDto}.
     *
     * @param source list of {@link User}
     * @return list of {@link UserAllResponseDto}
     */
    List<UserAllResponseDto> convertAll(List<User> source);

    /**
     * Map from {@link User} to {@link UserSlimResponseDto}.
     *
     * @param source {@link User}
     * @return {@link UserSlimResponseDto}
     */
    UserSlimResponseDto convertSlim(User source);

    /**
     * Map list of {@link User} to {@link UserSlimResponseDto}.
     *
     * @param source list of {@link User}
     * @return list of {@link UserSlimResponseDto}
     */
    List<UserSlimResponseDto> convertSlim(List<User> source);
}

