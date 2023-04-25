package com.waffle.services.entity.impl;

import com.waffle.data.constants.exceptions.NotFoundException;
import com.waffle.data.entities.Booking;
import com.waffle.repositories.BookingRepository;
import com.waffle.services.entity.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Booking service implementation.
 */
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;

    @Override
    public Booking save(final Booking payload) {
        return repository.save(payload);
    }

    @Override
    public List<Booking> findAll() {
        return repository.findAll();
    }

    @Override
    public Booking find(final Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Booking does not exist: " + id));
    }

    @Override
    public Booking update(final Booking payload) {
        return null;
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
