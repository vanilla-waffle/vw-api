package com.waffle.data.utils.mappers;

import com.waffle.configurations.MapperConfiguration;
import com.waffle.data.entities.Image;
import com.waffle.data.models.rest.response.image.ImageResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Media mapper.
 */
@Mapper(componentModel = "spring", config = MapperConfiguration.class)
public interface ImageMapper {

    /**
     * Map from {@link MultipartFile} to {@link Image}.
     *
     * @param source {@link MultipartFile}
     * @return {@link Image}
     */
    @Mapping(target = "type", expression = "java(source.getContentType())")
    @Mapping(target = "data", expression = "java(source.getBytes())")
    @Mapping(target = "size", expression = "java(source.getSize())")
    Image convert(MultipartFile source) throws IOException;

    /**
     * Map {@link List} of {@link MultipartFile} to {@link Image}.
     *
     * @param source {@link List} of {@link MultipartFile}
     * @return {@link List} of {@link Image}
     * @throws IOException io exception
     */
    List<Image> convert(List<MultipartFile> source) throws IOException;

    /**
     * Map from {@link Image} to {@link ImageResponseDto}.
     *
     * @param source {@link Image}
     * @return {@link ImageResponseDto}
     */
    ImageResponseDto convertResponse(Image source);

    /**
     * Map {@link List} of {@link Image} to {@link ImageResponseDto}.
     *
     * @param source {@link List} of {@link Image}
     * @return {@link List} of {@link ImageResponseDto}
     */
    List<ImageResponseDto> convertResponse(List<Image> source);
}
