package com.waffle.data.mappers;

import com.waffle.configurations.WaffleMapperConfig;
import com.waffle.data.dto.response.user.UserAllDto;
import com.waffle.data.dto.response.user.UserSlimDto;
import com.waffle.data.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mappers class for mapping {@link com.waffle.data.entities.User} entity.
 */
@Mapper(componentModel = "spring", config = WaffleMapperConfig.class)
public interface UserMapper {

    /**
     * Map from {@link User} to {@link UserAllDto}.
     *
     * @param source {@link User}
     * @return {@link UserAllDto}
     */
    UserAllDto convert(User source);

    /**
     * Map list of {@link User} to {@link UserAllDto}.
     *
     * @param source list of {@link User}
     * @return list of {@link UserAllDto}
     */
    List<UserAllDto> convert(List<User> source);

    /**
     * Map from {@link User} to {@link UserSlimDto}.
     *
     * @param source {@link User}
     * @return {@link UserSlimDto}
     */
    UserSlimDto convertSlim(User source);

    /**
     * Map list of {@link User} to {@link UserSlimDto}.
     *
     * @param source list of {@link User}
     * @return list of {@link UserSlimDto}
     */
    List<UserSlimDto> convertSlim(List<User> source);
}

