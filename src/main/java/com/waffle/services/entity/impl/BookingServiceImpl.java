package com.waffle.services.entity.impl;

import com.waffle.data.entities.Booking;
import com.waffle.data.utils.mappers.BookingMapper;
import com.waffle.data.repositories.BookingRepository;
import com.waffle.services.entity.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.waffle.data.repositories.specifications.BookingSpecification.byUser;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;
    private final BookingMapper mapper;

    @Override
    public Booking save(final Booking payload) {
        final List<Booking> bookings = findAll(byUser(payload.getUser().getId()));

        if (payload.overlaps(bookings)) {
            throw new IllegalArgumentException("Current booking overlaps with another existing ones.");
        }

        return repository.save(payload);
    }

    @Override
    public List<Booking> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Booking> findAll(final Specification<Booking> by) {
        return repository.findAll(by);
    }

    @Override
    public List<Booking> findAll(final Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Booking> findAll(final PageRequest page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Booking> findAll(final Sort sort, final PageRequest page) {
        return repository.findAll(page.withSort(sort));
    }

    @Override
    public Page<Booking> findAll(final Sort sort, final PageRequest page, final Specification<Booking> by) {
        return repository.findAll(by, page.withSort(sort));
    }

    @Override
    public Booking find(final Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Booking does not exist: " + id));
    }

    @Override
    public Booking find(final Specification<Booking> by) {
        return repository.findOne(by).orElseThrow(() -> new IllegalArgumentException("Booking does not exist"));
    }

    @Override
    public Booking merge(final Booking payload) {
        final long id = payload.getId();

        if (!exists(id)) {
            throw new IllegalArgumentException("Booking does not exist: " + id);
        }

        final Booking actual = find(id);
        final Booking booking = mapper.update(payload, actual);
        return repository.save(booking);
    }

    @Override
    public Booking update(final Booking payload) {
        final long id = payload.getId();

        if (!exists(id)) {
            throw new IllegalArgumentException("Booking does not exist: " + id);
        }

        return repository.save(payload);
    }

    @Override
    public void delete(final Long id) {
        if (!exists(id)) {
            throw new IllegalArgumentException("Booking does not exist: " + id);
        }

        repository.deleteById(id);
    }

    @Override
    public boolean exists(final Long id) {
        return repository.existsById(id);
    }

    @Override
    public boolean exists(final Specification<Booking> by) {
        return repository.exists(by);
    }
}
