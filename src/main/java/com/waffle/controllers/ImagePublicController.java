package com.waffle.controllers;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.services.composite.open.ImagePublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Api("public/media")
@RequiredArgsConstructor
public class ImagePublicController {
    private final ImagePublicService imagePublicService;

    @GetMapping(value = "/{uuid}", produces = "image/png")
    public byte[] download(@PathVariable final String uuid) {
        return imagePublicService.download(uuid);
    }
}
