package com.waffle.data.utils.mappers;

import com.waffle.configurations.MapperConfiguration;
import com.waffle.data.entities.Role;
import com.waffle.data.models.rest.request.user.role.RoleCreateDto;
import com.waffle.data.models.rest.response.user.role.RoleResponseAllDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", config = MapperConfiguration.class)
public interface RoleMapper {

    /**
     * Map from {@link RoleCreateDto} to {@link Role}.
     *
     * @param source {@link RoleCreateDto}
     * @return {@link Role}
     */
    Role convert(RoleCreateDto source);

    /**
     * Map from {@link Role} to {@link RoleResponseAllDto}.
     *
     * @param source {@link Role}
     * @return {@link RoleResponseAllDto}
     */
    RoleResponseAllDto convertAll(Role source);

    /**
     * Map list of {@link Role} to {@link RoleResponseAllDto}.
     *
     * @param source {@link List<Role>}
     * @return {@link List<RoleResponseAllDto>}
     */
    List<RoleResponseAllDto> convertAll(List<Role> source);
}
