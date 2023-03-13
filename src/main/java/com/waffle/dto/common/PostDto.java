package com.waffle.dto.common;

import lombok.Data;

import java.time.LocalDate;

/**
 * Common class for dto classes of Post.
 */
@Data
public class PostDto {
    private String title;
    private String description;
    private String manufacturer;
    private String model;
    private LocalDate releaseYear;
}
