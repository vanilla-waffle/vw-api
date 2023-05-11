package com.waffle.services.composite;

public interface ImagePublicService {

    /**
     * Download.
     *
     * @param id {@link Long}
     * @return array of {@code byte}
     */
    byte[] download(Long id);
}
