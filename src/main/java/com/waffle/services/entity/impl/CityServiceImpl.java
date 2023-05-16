package com.waffle.services.entity.impl;

import com.waffle.data.entities.City;
import com.waffle.data.repositories.CityRepository;
import com.waffle.services.entity.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository repository;

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }

    @Override
    public City find(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("City not found: " + id));
    }

    @Override
    public City find(final String name) {
        return repository.findByName(name).orElseThrow(() -> new IllegalArgumentException("City not found: " + name));
    }
}
