package com.waffle.data.models.rest.common;

import lombok.Data;

/**
 * Media dto.
 */
@Data
public class ImageDto {

    private String uuid;
    private String url;
    private String type;
    private String size;
}
