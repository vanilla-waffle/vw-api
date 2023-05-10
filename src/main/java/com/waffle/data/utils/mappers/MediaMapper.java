package com.waffle.data.utils.mappers;

import com.waffle.configurations.MapperConfiguration;
import com.waffle.data.entities.media.UserPictureMedia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Media mapper.
 */
@Mapper(componentModel = "spring", config = MapperConfiguration.class)
public interface MediaMapper {

    /**
     * Map from {@link MultipartFile} to {@link UserPictureMedia}.
     *
     * @param source {@link MultipartFile}
     * @return {@link UserPictureMedia}
     */
    @Mapping(target = "name", expression = "java(source.getOriginalFilename())")
    @Mapping(target = "type", expression = "java(source.getContentType())")
    @Mapping(target = "data", expression = "java(source.getBytes())")
    @Mapping(target = "size", expression = "java(source.getSize())")
    UserPictureMedia convert(MultipartFile source) throws IOException;
}
