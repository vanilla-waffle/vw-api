package com.waffle.controllers.internal;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.rest.response.media.ImageResponseDto;
import com.waffle.services.composite.internal.VehicleImageInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Positive;
import java.util.List;

@Api("in/vehicles")
@RequiredArgsConstructor
public class VehicleImageController {
    private final VehicleImageInternalService vehicleImageInternalService;

    /**
     * Upload vehicle images.
     *
     * @param vehicleId {@link Long}
     * @param files array of {@link MultipartFile}
     * @return {@link List} of {@link ImageResponseDto}
     */
    @PutMapping("/{vehicleId}/images")
    public List<ImageResponseDto> upload(
            @PathVariable final Long vehicleId,
            @RequestPart("files") final MultipartFile[] files) {
        return vehicleImageInternalService.upload(vehicleId, List.of(files));
    }

    /**
     * Delete.
     *
     * @param userId {@link Long}
     * @param vehicleId {@link Long}
     * @param uuid {@link String}
     */
    @DeleteMapping("/{vehicleId}/images/{uuid}")
    public void delete(
            @Principal final Long userId,
            @PathVariable @Positive final Long vehicleId,
            @PathVariable final String uuid) {
        vehicleImageInternalService.delete(vehicleId, uuid);
    }
}
