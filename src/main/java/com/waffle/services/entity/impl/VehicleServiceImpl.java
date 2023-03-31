package com.waffle.services.entity.impl;

import com.waffle.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * PostService implementation.
 */
@Service
@RequiredArgsConstructor
public class VehicleServiceImpl {
    private final VehicleRepository repository;
}
