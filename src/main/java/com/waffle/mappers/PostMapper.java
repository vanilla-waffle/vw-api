package com.waffle.mappers;

import com.waffle.configurations.WaffleMapperConfig;
import com.waffle.data.dto.request.PostCreateDto;
import com.waffle.data.dto.request.PostUpdateDto;
import com.waffle.data.dto.response.PostAllDto;
import com.waffle.data.dto.response.PostSlimDto;
import com.waffle.data.entity.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mappers class for mapping {@link Vehicle} entity.
 */
@Mapper(componentModel = "spring", config = WaffleMapperConfig.class)
public interface PostMapper {

    /**
     * Map from {@link PostCreateDto} to {@link Vehicle}.
     *
     * @param source post create dto
     * @return post entity
     */
    Vehicle fromCreateDtoToPost(PostCreateDto source);

    /**
     * Map from {@link PostUpdateDto} to {@link Vehicle}.
     *
     * @param source post update dto
     * @return post entity
     */
    Vehicle fromUpdateDtoToPost(PostUpdateDto source);

    /**
     * Map from {@link Vehicle} to {@link PostAllDto}.
     *
     * @param source post
     * @return all response dto
     */
    PostAllDto fromPostToAllDto(Vehicle source);

    /**
     * Map lists from {@link Vehicle} to {@link PostAllDto}.
     *
     * @param source posts list
     * @return all response dto list
     */
    default List<PostAllDto> fromPostToAllDto(final List<Vehicle> source) {
        return source.stream()
                .map(this::fromPostToAllDto)
                .collect(Collectors.toList());
    }

    /**
     * Map from {@link Vehicle} to {@link PostSlimDto}.
     *
     * @param source post
     * @return slim response dto
     */
    PostSlimDto fromPostToSlimDto(Vehicle source);

    /**
     * Map lists from {@link Vehicle} to {@link PostSlimDto}.
     *
     * @param source posts list
     * @return slim response dto list
     */
    default List<PostSlimDto> fromPostToSlimDto(final List<Vehicle> source) {
        return source.stream()
                .map(this::fromPostToSlimDto)
                .collect(Collectors.toList());
    }
}
