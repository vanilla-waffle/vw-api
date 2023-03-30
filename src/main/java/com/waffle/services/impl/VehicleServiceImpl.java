package com.waffle.services.impl;

import com.waffle.repositories.VehicleRepository;
import com.waffle.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * PostService implementation.
 */
@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository repository;
}
