package com.waffle.services.composite.open.impl;

import com.waffle.data.entities.Image;
import com.waffle.services.composite.open.ImagePublicService;
import com.waffle.services.entity.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImagePublicServiceImpl implements ImagePublicService {
    private final ImageService imageService;

    @Override
    public byte[] download(final String uuid) {
        final Image image = imageService.download(uuid);
        return image.getData();
    }
}
