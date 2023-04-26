package com.waffle.services.composite.impl;

import com.waffle.data.entities.Booking;
import com.waffle.data.entities.User;
import com.waffle.data.entities.Vehicle;
import com.waffle.data.mappers.BookingMapper;
import com.waffle.data.models.rest.request.booking.BookingCreateDto;
import com.waffle.data.models.rest.request.booking.BookingUpdateDto;
import com.waffle.data.models.rest.response.booking.BookingAllResponseDto;
import com.waffle.data.utils.Sorts;
import com.waffle.services.composite.BookingInternalService;
import com.waffle.services.entity.BookingService;
import com.waffle.services.entity.UserService;
import com.waffle.services.entity.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.waffle.repositories.specifications.BookingSpecification.byUser;
import static com.waffle.repositories.specifications.BookingSpecification.byVehicle;

/**
 * Booking internal service implementation.
 */
@Service
@RequiredArgsConstructor
public class BookingInternalServiceImpl implements BookingInternalService {
    private final BookingService bookingService;
    private final VehicleService vehicleService;
    private final UserService userService;
    private final BookingMapper bookingMapper;

    @Override
    public BookingAllResponseDto save(final BookingCreateDto payload) {
        final User user = userService.find(payload.getUserId());
        final Vehicle vehicle = vehicleService.find(payload.getVehicleId());

        Booking booking = bookingMapper.convert(payload);
        booking.setUser(user);
        booking.setVehicle(vehicle);

        booking = bookingService.save(booking);
        return bookingMapper.convertAll(booking);
    }

    @Override
    public List<BookingAllResponseDto> findAll(final String query) {
        final Sort sort = Sorts.of(query);
        final List<Booking> bookings = bookingService.findAll(sort);
        return bookingMapper.convertAll(bookings);
    }

    @Override
    public Page<BookingAllResponseDto> findAll(final String query, final PageRequest page) {
        final Sort sort = Sorts.of(query);
        final Page<Booking> bookings = bookingService.findAll(sort, page);
        return bookings.map(bookingMapper::convertAll);
    }

    @Override
    public Page<BookingAllResponseDto> findAllByUser(final String query, final PageRequest page, final Long userId) {
        final Sort sort = Sorts.of(query);
        final Page<Booking> bookings = bookingService.findAll(sort, page, byUser(userId));
        return bookings.map(bookingMapper::convertAll);
    }

    @Override
    public Page<BookingAllResponseDto> findAllByVehicle(final String query, final PageRequest page, final Long vehicleId) {
        final Sort sort = Sorts.of(query);
        final Page<Booking> bookings = bookingService.findAll(sort, page, byVehicle(vehicleId));
        return bookings.map(bookingMapper::convertAll);
    }

    @Override
    public BookingAllResponseDto find(final Long id) {
        final Booking booking = bookingService.find(id);
        return bookingMapper.convertAll(booking);
    }

    @Override
    public BookingAllResponseDto update(final BookingUpdateDto payload) {
        Booking booking = bookingMapper.convert(payload);
        booking = bookingService.update(booking);
        return bookingMapper.convertAll(booking);
    }

    @Override
    @Transactional
    public void delete(final Long id) {
        bookingService.delete(id);
    }
}
