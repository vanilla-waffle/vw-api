package com.waffle.services.composite.internal.impl;

import com.waffle.data.entities.Image;
import com.waffle.data.entities.Vehicle;
import com.waffle.data.models.rest.response.image.ImageResponseDto;
import com.waffle.data.utils.mappers.ImageMapper;
import com.waffle.services.composite.internal.VehicleImageInternalService;
import com.waffle.services.entity.ImageService;
import com.waffle.services.entity.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleImageInternalServiceImpl implements VehicleImageInternalService {
    private final VehicleService vehicleService;
    private final ImageService imageService;
    private final ImageMapper imageMapper;

    @Override
    @Transactional
    public ImageResponseDto upload(final Long ownerId, final MultipartFile file) {
        return upload(ownerId, List.of(file)).get(0);
    }

    @Override
    @Transactional
    public List<ImageResponseDto> upload(final Long ownerId, final List<MultipartFile> files) {
        final Vehicle vehicle = vehicleService.find(ownerId);
        List<Image> images;

        try {
            images = imageMapper.convert(files);
            images = imageService.upload(images);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        vehicle.setImages(images);
        vehicleService.update(vehicle);
        return imageMapper.convertResponse(images);
    }

    @Override
    public void delete(final Long ownerId, final String uuid) {
        final Vehicle vehicle = vehicleService.find(ownerId);
        vehicle.getImages().removeIf(i -> i.getUuid().equals(uuid));
        vehicleService.update(vehicle);
    }
}
