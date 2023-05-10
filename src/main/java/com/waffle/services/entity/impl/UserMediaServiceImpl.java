package com.waffle.services.entity.impl;

import com.waffle.data.entities.media.UserPictureMedia;
import com.waffle.repositories.UserMediaRepository;
import com.waffle.services.entity.UserMediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User media service implementation.
 */
@Service
@RequiredArgsConstructor
public class UserMediaServiceImpl implements UserMediaService {
    private final UserMediaRepository repository;

    @Override
    public UserPictureMedia save(final UserPictureMedia payload) {
        return repository.save(payload);
    }

    @Override
    public List<UserPictureMedia> findAll() {
        return repository.findAll();
    }

    @Override
    public UserPictureMedia find(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Media not found: " + id));
    }

    @Override
    public UserPictureMedia merge(final UserPictureMedia payload) {
        return repository.save(payload);
    }

    @Override
    public UserPictureMedia update(final UserPictureMedia payload) {
        return merge(payload);
    }

    @Override
    public void delete(final Long id) {
        if (!exists(id)) {
            throw new IllegalArgumentException("Media not found: " + id);
        }

        repository.deleteById(id);
    }

    @Override
    public boolean exists(final Long id) {
        return repository.existsById(id);
    }
}
