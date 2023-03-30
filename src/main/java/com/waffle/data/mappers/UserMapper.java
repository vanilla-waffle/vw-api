package com.waffle.data.mappers;

import com.waffle.data.dto.response.user.UserAllDto;
import com.waffle.data.dto.response.user.UserSlimDto;
import com.waffle.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Mappers class for mapping {@link com.waffle.data.entity.User} entity.
 */
@Mapper
//@Mapper(componentModel = "spring", config = WaffleMapperConfig.class)
public interface UserMapper {

    /**
     * Mapper instance.
     */
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserAllDto convert(User source);

    List<UserAllDto> convert(List<User> source);

    User convert(UserAllDto source);

    UserSlimDto convertSlim(User source);

    List<UserSlimDto> convertSlim(List<User> source);

    User convertSlim(UserSlimDto source);
}

