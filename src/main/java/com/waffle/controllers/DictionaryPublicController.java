package com.waffle.controllers;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.entities.City;
import com.waffle.services.composite.open.DictionaryPublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Api("public/dict")
@RequiredArgsConstructor
public class DictionaryPublicController {
    private final DictionaryPublicService dictionaryPublicService;

    /**
     * Find all cities.
     *
     * @return {@link List} of {@link City}
     */
    @GetMapping("/cities")
    public List<City> findAllCities() {
        return dictionaryPublicService.findAllCities();
    }
}
