package com.waffle.services.entity.impl;

import com.waffle.data.entities.Image;
import com.waffle.data.repositories.ImageRepository;
import com.waffle.services.entity.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Image service implementation.
 */
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository repository;

    @Override
    public Image download(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Image not found: " + id));
    }

    @Override
    public Image upload(final Image payload) {
        return repository.save(payload);
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
