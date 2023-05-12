package com.waffle.services.composite.open;

public interface ImagePublicService {

    /**
     * Download.
     *
     * @param uuid {@link String}
     * @return array of {@code byte}
     */
    byte[] download(String uuid);
}
