package com.waffle.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * File service for file manipulations.
 */
public interface FileService {

    boolean upload(MultipartFile file, String name);

    File download(String name);

    boolean delete(String name);
}
