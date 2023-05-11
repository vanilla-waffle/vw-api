package com.waffle.services.composite;

import com.waffle.data.models.rest.response.media.ImageResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**(
 * Image internal service.
 */
public interface ImageInternalService {

    /**
     * Upload.
     *
     * @param file {@link MultipartFile}
     * @return {@link ImageResponseDto}
     */
    ImageResponseDto upload(MultipartFile file);

    /**
     * Upload all.
     *
     * @param files {@link List<MultipartFile>}
     * @return {@link List<ImageResponseDto>}
     */
    List<ImageResponseDto> upload(List<MultipartFile> files);

    /**
     * Delete.
     *
     * @param id {@link Long}
     */
    void delete(Long id);
}
