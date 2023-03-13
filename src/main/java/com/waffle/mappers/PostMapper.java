package com.waffle.mappers;

import com.waffle.dto.request.PostCreateDto;
import com.waffle.dto.request.PostUpdateDto;
import com.waffle.models.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * Mappers class for mapping {@link com.waffle.models.entity.Post} entity.
 */
@Mapper(config = WaffleMapperConfig.class)
public interface PostMapper {
    /**
     * The INSTANCE of {@link com.waffle.mappers.PostMapper}.
     */
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    /**
     * Map from {@link com.waffle.dto.request.PostCreateDto} to {@link Post}.
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
