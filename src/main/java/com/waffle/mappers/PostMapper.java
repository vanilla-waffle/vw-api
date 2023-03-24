package com.waffle.mappers;

import com.waffle.configurations.WaffleMapperConfig;
import com.waffle.data.dto.request.PostCreateDto;
import com.waffle.data.dto.request.PostUpdateDto;
import com.waffle.data.dto.response.PostAllDto;
import com.waffle.data.dto.response.PostSlimDto;
import com.waffle.data.entity.Post;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mappers class for mapping {@link com.waffle.data.entity.Post} entity.
 */
@Mapper(componentModel = "spring", config = WaffleMapperConfig.class)
public interface PostMapper {

    /**
     * Map from {@link PostCreateDto} to {@link Post}.
     *
     * @param source post create dto
     * @return post entity
     */
    Post fromCreateDtoToPost(PostCreateDto source);

    /**
     * Map from {@link PostUpdateDto} to {@link Post}.
     *
     * @param source post update dto
     * @return post entity
     */
    Post fromUpdateDtoToPost(PostUpdateDto source);

    /**
     * Map from {@link Post} to {@link PostAllDto}.
     *
     * @param source post
     * @return all response dto
     */
    PostAllDto fromPostToAllDto(Post source);

    /**
     * Map lists from {@link Post} to {@link PostAllDto}.
     *
     * @param source posts list
     * @return all response dto list
     */
    default List<PostAllDto> fromPostToAllDto(final List<Post> source) {
        return source.stream()
                .map(this::fromPostToAllDto)
                .collect(Collectors.toList());
    }

    /**
     * Map from {@link Post} to {@link PostSlimDto}.
     *
     * @param source post
     * @return slim response dto
     */
    PostSlimDto fromPostToSlimDto(Post source);

    /**
     * Map lists from {@link Post} to {@link PostSlimDto}.
     *
     * @param source posts list
     * @return slim response dto list
     */
    default List<PostSlimDto> fromPostToSlimDto(final List<Post> source) {
        return source.stream()
                .map(this::fromPostToSlimDto)
                .collect(Collectors.toList());
    }
}
