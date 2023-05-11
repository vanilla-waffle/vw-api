package com.waffle.controllers.internal;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.services.composite.ImageInternalService;
import lombok.RequiredArgsConstructor;

@Api("/in/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageInternalService imageInternalService;
}
