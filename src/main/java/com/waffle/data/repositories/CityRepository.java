package com.waffle.data.repositories;

import com.waffle.data.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    /**
     * Find by name.
     *
     * @param name {@link String}
     * @return {@link Optional} of {@link City}
     */
    Optional<City> findByName(String name);
}
