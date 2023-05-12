package com.waffle.controllers.internal;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.rest.response.media.ImageResponseDto;
import com.waffle.services.composite.internal.UserImageInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Api("in/users")
@RequiredArgsConstructor
public class UserImageController {
    private final UserImageInternalService userImageInternalService;

    @PutMapping("/me/media")
    public ImageResponseDto upload(
            @Principal final Long userId,
            @RequestPart("file") final MultipartFile file) {
        return userImageInternalService.upload(userId, file);
    }

    @DeleteMapping("/me/media")
    public void delete(@Principal final Long userId) {
        userImageInternalService.delete(userId, null);
    }
}
