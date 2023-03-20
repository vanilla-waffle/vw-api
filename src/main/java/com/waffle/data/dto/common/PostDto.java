package com.waffle.data.dto.common;

import lombok.Data;

/**
 * Common class for dto classes of Post.
 */
@Data
public class PostDto {
    private String title;
    private String description;
    private String manufacturer;
    private String model;
    private Integer releaseYear;
}
