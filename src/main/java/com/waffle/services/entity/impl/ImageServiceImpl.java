package com.waffle.services.entity.impl;

import com.google.common.collect.Lists;
import com.waffle.data.entities.Image;
import com.waffle.data.repositories.ImageRepository;
import com.waffle.services.entity.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository repository;

    @Override
    public Image download(final String uuid) {
        return repository.findByUuid(uuid).orElseThrow(() -> new IllegalArgumentException("Image does not exist: " + uuid));
    }

    @Override
    public Image upload(final Image payload) {
        return repository.save(payload);
    }

    @Override
    public List<Image> upload(final List<Image> payloads) {
        return Lists.newArrayList(repository.saveAll(payloads));
    }

    @Override
    public void delete(final String uuid) {
        repository.deleteByUuid(uuid);
    }

    @Override
    public boolean valid(final Image payload) {
        return payload.getType().equals("image/png");
    }
}
