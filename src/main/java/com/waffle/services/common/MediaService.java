package com.waffle.services.common;

import java.util.List;

/**
 * Media service.
 */
public interface MediaService<T> {

    T download(Long id);

    T upload(T payload);

    List<T> uploadAll(List<T> payloads);

    void delete(Long id);
}
