package com.waffle.data.dto.common;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

/**
 * Common class for dto classes of Post.
 */
@Data
public class PostDto {

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private String manufacturer;

    @NotEmpty
    private String model;

    @NotEmpty
    @Positive
    private Integer releaseYear;
}
