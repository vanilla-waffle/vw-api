package com.waffle.mappers;

import com.waffle.data.dto.request.UserCreateDto;
import com.waffle.data.dto.request.UserUpdateDto;
import com.waffle.data.dto.response.UserAllDto;
import com.waffle.data.dto.response.UserSlimDto;
import com.waffle.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

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
    User fromCreateDtoToUser(UserCreateDto source);

    /**
     * Map from {@link UserUpdateDto} to {@link User}.
     *
     * @param source user update dto
     * @return user entity
     */
    User fromUpdateDtoToUser(UserUpdateDto source);

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
    UserAllDto fromUserToAllDto(User source);

    /**
     * Map lists from {@link User} to {@link UserAllDto}.
     *
     * @param source users list
     * @return all response dto list
     */
    default List<UserAllDto> fromUserToAllDto(final List<User> source) {
        return source.stream()
                .map(this::fromUserToAllDto)
                .collect(Collectors.toList());
    }

    /**
     * Map from {@link User} to {@link UserSlimDto}.
     *
     * @param source user
     * @return slim response dto
     */
    @Mapping(target = "profile.email", source = "profile.email")
    @Mapping(target = "profile.firstName", source = "profile.firstName")
    @Mapping(target = "profile.lastName", source = "profile.lastName")
    @Mapping(target = "profile.city", source = "profile.city")
    UserSlimDto fromUserToSlimDto(User source);

    /**
     * Map lists from {@link User} to {@link UserSlimDto}.
     *
     * @param source users list
     * @return slim response dto list
     */
    default List<UserSlimDto> fromUserToSlimDto(List<User> source) {
        return source.stream()
                .map(this::fromUserToSlimDto)
                .collect(Collectors.toList());
    }
}
