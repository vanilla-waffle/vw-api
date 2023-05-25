package com.waffle.services.composite.internal.impl;

import com.waffle.data.entities.Image;
import com.waffle.data.entities.User;
import com.waffle.data.models.rest.response.image.ImageResponseDto;
import com.waffle.data.utils.mappers.ImageMapper;
import com.waffle.services.composite.internal.UserImageInternalService;
import com.waffle.services.entity.ImageService;
import com.waffle.services.entity.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserImageInternalServiceImpl implements UserImageInternalService {
    private final UserService userService;
    private final ImageService imageService;
    private final ImageMapper imageMapper;

    @Override
    @Transactional
    public ImageResponseDto upload(final Long ownerId, final MultipartFile file) {
        final User user = userService.find(ownerId);
        Image image;

        try {
            image = imageMapper.convert(file);
            image = imageService.upload(image);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        user.getProfile().setImage(image);
        userService.update(user);
        return imageMapper.convertResponse(image);
    }

    @Override
    @Transactional
    public List<ImageResponseDto> upload(final Long ownerId, final List<MultipartFile> files) {
        return List.of(upload(ownerId, files.get(0)));
    }

    @Override
    public void delete(final Long ownerId, final String uuid) {
        final User user = userService.find(ownerId);
        user.clearImage();
        userService.update(user);
    }
}
