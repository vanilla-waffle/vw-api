package com.waffle.controllers.internal.booking;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.rest.response.booking.BookingAllResponseDto;
import com.waffle.services.composite.internal.BookingInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Positive;

/**
 * Booking cross controller.
 */
@Api("in")
@RequiredArgsConstructor
public class BookingCrossController {
    private final BookingInternalService bookingInternalService;

    /**
     * Find all.
     *
     * @param userId {@link Long}
     * @param page {@code int}
     * @param size {@code int}
     * @param sort {@link String}
     * @return {@link Page<BookingAllResponseDto>}
     */
    @GetMapping("/users/me/bookings")
    public Page<BookingAllResponseDto> findAllByUserMy(
            @Principal final Long userId,
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
        return bookingInternalService.findAllByUser(sort, PageRequest.of(page, size), userId);
    }

    /**
     * Find all pending.
     *
     * @param userId {@link Long}
     * @param page {@code int}
     * @param size {@code int}
     * @param sort {@link String}
     * @return {@link Page<BookingAllResponseDto>}
     */
    @GetMapping("/users/me/bookings/pending")
    public Page<BookingAllResponseDto> findAllByUserMyPending(
            @Principal final Long userId,
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
        return bookingInternalService.findAllPending(sort, PageRequest.of(page, size), userId);
    }

    /**
     * Find all.
     *
     * @param userId {@link Long}
     * @param page {@code int}
     * @param size {@code int}
     * @param sort {@link String}
     * @return {@link Page<BookingAllResponseDto>}
     */
    @GetMapping("/users/{userId}/bookings")
    public Page<BookingAllResponseDto> findAllByUser(
            @PathVariable @Positive final Long userId,
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
        return bookingInternalService.findAllByUser(sort, PageRequest.of(page, size), userId);
    }

    /**
     * Find all.
     *
     * @param vehicleId {@link Long}
     * @param page {@code int}
     * @param size {@code int}
     * @param sort {@link String}
     * @return {@link Page<BookingAllResponseDto>}
     */
    @GetMapping("/vehicles/{vehicleId}/bookings")
    public Page<BookingAllResponseDto> findAllByVehicles(
            @PathVariable final Long vehicleId,
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
        return bookingInternalService.findAllByVehicle(sort, PageRequest.of(page, size), vehicleId);
    }
}
