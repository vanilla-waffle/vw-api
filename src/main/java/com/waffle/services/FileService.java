package com.waffle.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * File service for file manipulations.
 */
public interface FileService {

    /**
     * Upload file to a cloud storoge.
     *
     * @param file file to upload
     * @param name file name
     */
    void upload(MultipartFile file, String name);

    /**
     * Download file from a cloud storage.
     *
     * @param name file name
     * @return file instance
     */
    File download(String name);

    /**
     * Delete file from a cloud storage.
     *
     * @param name file name
     */
    void delete(String name);
}
