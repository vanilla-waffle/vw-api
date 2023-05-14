package com.waffle.controllers;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.services.composite.open.ImagePublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@Api("public/media")
@RequiredArgsConstructor
public class ImagePublicController {
    private final ImagePublicService imagePublicService;

    /**
     * Download image.
     *
     * @param uuid {@link String}
     * @return array of {@code byte}
     */
    @GetMapping(
            value = "/{uuid}",
            produces = { IMAGE_PNG_VALUE, IMAGE_JPEG_VALUE }
    )
    public byte[] download(@PathVariable final String uuid) {
        return imagePublicService.download(uuid);
    }
}
