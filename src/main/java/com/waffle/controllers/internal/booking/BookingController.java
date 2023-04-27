package com.waffle.controllers.internal.booking;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.rest.request.booking.BookingCreateDto;
import com.waffle.data.models.rest.request.booking.BookingUpdateDto;
import com.waffle.data.models.rest.response.booking.BookingAllResponseDto;
import com.waffle.services.composite.BookingInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Booking controller.
 */
@Api("/in/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingInternalService bookingInternalService;

    /**
     * Find one.
     *
     * @param id {@link Long}
     * @return {@link }
     */
    @GetMapping("/{id}")
    public BookingAllResponseDto find(@PathVariable final Long id) {
        return bookingInternalService.find(id);
    }

    /**
     * Save one.
     *
     * @param userId {@link Long}
     * @param payload {@link BookingCreateDto}
     * @return {@link }
     */
    @PostMapping
    @ResponseStatus(CREATED)
    public BookingAllResponseDto save(
            @Principal final Long userId,
            @RequestBody @Valid final BookingCreateDto payload) {
        payload.setUserId(userId);
        return bookingInternalService.save(payload);
    }

    /**
     * Update one.
     *
     * @param userId {@link Long}
     * @param payload {@link BookingUpdateDto}
     * @return {@link BookingAllResponseDto}
     */
    @PatchMapping
    public BookingAllResponseDto update(
            @Principal final Long userId,
            @RequestBody @Valid final BookingUpdateDto payload) {
        payload.setUserId(userId);
        return bookingInternalService.update(payload);
    }

    /**
     * Delete one.
     *
     * @param id {@link Long}
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) {
        bookingInternalService.delete(id);
    }
}
