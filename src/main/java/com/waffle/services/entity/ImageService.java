package com.waffle.services.entity;

import com.waffle.data.entities.Image;

import java.util.List;

/**
 * Image service.
 */
public interface ImageService {

    /**
     * Download.
     *
     * @param uuid {@link String}
     * @return {@link Image}
     */
    Image download(String uuid);

    /**
     * Upload.
     *
     * @param payload {@link Image}
     * @return {@link Image}
     */
    Image upload(Image payload);

    /**
     * Upload all.
     *
     * @param payloads {@link List} of {@link Image}
     * @return {@link List} of {@link Image}
     */
    List<Image> upload(List<Image> payloads);

    /**
     * Delete.
     *
     * @param uuid {@link String}
     */
    void delete(String uuid);

    /**
     * Check whether provided {@link Image} is valid or not.
     *
     * @param payload {@link Image}
     * @return {@code boolean}
     */
    boolean valid(Image payload);
}
