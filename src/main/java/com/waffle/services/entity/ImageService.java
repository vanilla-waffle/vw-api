package com.waffle.services.entity;

import com.waffle.data.entities.Image;

public interface ImageService {

    /**
     * Download.
     *
     * @param id {@link Long}
     * @return {@link Image}
     */
    Image download(Long id);

    /**
     * Upload.
     *
     * @param payload {@link Image}
     * @return {@link Image}
     */
    Image upload(Image payload);

    /**
     * Delete.
     *
     * @param id {@link Long}
     */
    void delete(Long id);
}
