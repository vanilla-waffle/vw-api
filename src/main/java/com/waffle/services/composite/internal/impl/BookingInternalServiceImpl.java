package com.waffle.services.composite.internal.impl;

import com.waffle.data.constants.types.booking.BookingStatus;
import com.waffle.data.constants.types.vehicle.VehicleStatus;
import com.waffle.data.entities.Booking;
import com.waffle.data.entities.User;
import com.waffle.data.entities.Vehicle;
import com.waffle.data.utils.mappers.BookingMapper;
import com.waffle.data.models.rest.request.booking.BookingCreateDto;
import com.waffle.data.models.rest.request.booking.BookingUpdateDto;
import com.waffle.data.models.rest.response.booking.BookingAllResponseDto;
import com.waffle.services.utils.Sorts;
import com.waffle.services.composite.internal.BookingInternalService;
import com.waffle.services.entity.BookingService;
import com.waffle.services.entity.UserService;
import com.waffle.services.entity.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.waffle.data.repositories.specifications.BookingSpecification.*;
import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class BookingInternalServiceImpl implements BookingInternalService {
    private final BookingService bookingService;
    private final VehicleService vehicleService;
    private final UserService userService;
    private final BookingMapper bookingMapper;

    @Override
    @Transactional
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
    @Transactional
    public List<BookingAllResponseDto> findAll(final String query) {
        final Sort sort = Sorts.of(query);
        final List<Booking> bookings = bookingService.findAll(sort);
        return bookingMapper.convertAll(bookings);
    }

    @Override
    @Transactional
    public Page<BookingAllResponseDto> findAll(final String query, final PageRequest page) {
        final Sort sort = Sorts.of(query);
        final Page<Booking> bookings = bookingService.findAll(sort, page);
        return bookings.map(bookingMapper::convertAll);
    }

    @Override
    @Transactional
    public Page<BookingAllResponseDto> findAllByUser(final String query, final PageRequest page, final Long userId) {
        final Sort sort = Sorts.of(query);
        final Page<Booking> bookings = bookingService.findAll(sort, page, byUser(userId));
        return bookings.map(bookingMapper::convertAll);
    }

    @Override
    @Transactional
    public Page<BookingAllResponseDto> findAllByVehicle(final String query, final PageRequest page, final Long vehicleId) {
        final Sort sort = Sorts.of(query);
        final Page<Booking> bookings = bookingService.findAll(sort, page, byVehicle(vehicleId));
        return bookings.map(bookingMapper::convertAll);
    }

    @Override
    @Transactional
    public Page<BookingAllResponseDto> findAllPending(final String query, final PageRequest page, final Long userId) {
        final Sort sort = Sorts.of(query);
        final Specification<Booking> spec = byUser(userId).and(byStatus(BookingStatus.PENDING).or(byStatus(BookingStatus.ACTIVE)));
        final Page<Booking> bookings = bookingService.findAll(sort, page, spec);
        return bookings.map(bookingMapper::convertAll);
    }

    @Override
    @Transactional
    public BookingAllResponseDto find(final Long id) {
        final Booking booking = bookingService.find(id);
        return bookingMapper.convertAll(booking);
    }

    @Override
    @Transactional
    public BookingAllResponseDto update(final BookingUpdateDto payload) {
        Booking booking = bookingMapper.convert(payload);
        booking = bookingService.merge(booking);
        return bookingMapper.convertAll(booking);
    }

    @Override
    @Transactional
    public void delete(final Long id) {
        bookingService.delete(id);
    }

    @Override
    @Transactional
    public BookingAllResponseDto approve(final Long userId, final Long id) {
        Booking booking = bookingService.find(id);
        final Vehicle vehicle = booking.getVehicle();
        final User owner = vehicle.getUser();

        if (!booking.getStatus().equals(BookingStatus.PENDING)) {
            throw new IllegalArgumentException("Booking can not be approved since it has status: " + booking.getStatus());
        }

        if (!owner.getId().equals(userId)) {
            throw new IllegalArgumentException("Illegal Access: Booking can be approved only by vehicle owner.");
        }

        vehicle.setStatus(VehicleStatus.RESERVED);
        booking.setStatus(BookingStatus.ACTIVE);
        booking = bookingService.update(booking);
        vehicleService.update(vehicle);
        return bookingMapper.convertAll(booking);
    }

    @Override
    @Transactional
    public BookingAllResponseDto reject(final Long userId, final Long id) {
        Booking booking = bookingService.find(id);
        final Vehicle vehicle = booking.getVehicle();
        final User owner = vehicle.getUser();

        if (!booking.getStatus().equals(BookingStatus.PENDING)) {
            throw new IllegalArgumentException("Booking can not be rejected since it has status: " + booking.getStatus());
        }

        if (!owner.getId().equals(userId)) {
            throw new IllegalArgumentException("Illegal access: Booking can be rejected only by vehicle owner.");
        }

        booking.setStatus(BookingStatus.REJECTED);
        booking = bookingService.update(booking);
        return bookingMapper.convertAll(booking);
    }

    @Override
    @Transactional
    public BookingAllResponseDto cancel(final Long userId, final Long id) {
        Booking booking = bookingService.find(id);
        final Vehicle vehicle = booking.getVehicle();
        final User user = booking.getUser();
        final LocalDateTime startsAt = booking.getStartsAt();

        if (!user.getId().equals(userId)) {
            if (!vehicle.getUser().getId().equals(userId)) {
                throw new IllegalArgumentException("Illegal access: Booking can be cancelled only by initiator.");
            }
        }

        if (now().isAfter(startsAt)) {
            throw new IllegalArgumentException("Booking can not be cancelled after it was started: " + startsAt);
        }

        vehicle.setStatus(VehicleStatus.ACTIVE);
        booking.setStatus(BookingStatus.CANCELED);
        booking = bookingService.update(booking);
        vehicleService.update(vehicle);
        return bookingMapper.convertAll(booking);
    }

    @Override
    @Transactional
    public BookingAllResponseDto complete(final Long userId, final Long id) {
        Booking booking = bookingService.find(id);
        final Vehicle vehicle = booking.getVehicle();
        final User user = booking.getUser();

        if (!booking.getStatus().equals(BookingStatus.ACTIVE)) {
            throw new IllegalArgumentException("Booking can not be completed since it's not in active status");
        }

        if (!user.getId().equals(userId)) {
            throw new IllegalArgumentException("Illegal access: Booking can be completed only by initiator.");
        }

        vehicle.setStatus(VehicleStatus.ACTIVE);
        booking.setStatus(BookingStatus.COMPLETED);
        booking = bookingService.update(booking);
        vehicleService.update(vehicle);
        return bookingMapper.convertAll(booking);
    }
}
