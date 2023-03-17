package com.waffle.mappers;

import com.waffle.data.dto.request.PostCreateDto;
import com.waffle.data.dto.request.PostUpdateDto;
import com.waffle.data.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

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
    Post postCreateDtoToPost(PostCreateDto source);

    /**
     * Compares and directly updates post.
     *
     * @param source post dto
     * @param post actual post
     */
    void updatePostFromPostUpdateDto(PostUpdateDto source, @MappingTarget Post post);
}
