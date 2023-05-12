package com.waffle.services.composite.internal;

import com.waffle.data.models.rest.response.image.ImageResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**(
 * Image internal service.
 */
public interface ImageInternalService {

    /**
     * Upload.
     *
     * @param ownerId {@link Long}
     * @param file {@link MultipartFile}
     * @return {@link ImageResponseDto}
     */
    ImageResponseDto upload(Long ownerId, MultipartFile file);

    /**
     * Upload all.
     *
     * @param ownerId {@link Long}
     * @param files {@link List<MultipartFile>}
     * @return {@link List<ImageResponseDto>}
     */
    List<ImageResponseDto> upload(Long ownerId, List<MultipartFile> files);

    /**
     * Delete.
     *
     * @param ownerId {@link Long}
     * @param uuid    {@link String}
     */
    void delete(Long ownerId, String uuid);
}
