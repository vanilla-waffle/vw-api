package com.waffle.services.composite.open.impl;

import com.waffle.data.entities.City;
import com.waffle.services.composite.open.DictionaryPublicService;
import com.waffle.services.entity.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DictionaryPublicServiceImpl implements DictionaryPublicService {
    private final CityService cityService;

    @Override
    public List<City> findAllCities() {
        return cityService.findAll();
    }
}
