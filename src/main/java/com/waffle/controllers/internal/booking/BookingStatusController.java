package com.waffle.controllers.internal.booking;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.rest.response.booking.BookingAllResponseDto;
import com.waffle.services.composite.BookingInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.constraints.Positive;

/**
 * Booking status controller.
 */
@Api("in/bookings")
@RequiredArgsConstructor
public class BookingStatusController {
    private final BookingInternalService bookingInternalService;

    /**
     * Approve booking.
     *
     * @param userId {@link Long}
     * @param id {@link Long}
     * @return {@link BookingAllResponseDto}
     */
    @PutMapping("/{id}/approve")
    public BookingAllResponseDto approve(
            @Principal final Long userId,
            @PathVariable @Positive final Long id) {
        return bookingInternalService.approve(userId, id);
    }

    /**
     * Reject booking.
     *
     * @param userId {@link Long}
     * @param id {@link Long}
     * @return {@link BookingAllResponseDto}
     */
    @PutMapping("/{id}/reject")
    public BookingAllResponseDto reject(
            @Principal final Long userId,
            @PathVariable @Positive final Long id) {
        return bookingInternalService.reject(userId, id);
    }

    /**
     * Cancel booking.
     *
     * @param userId {@link Long}
     * @param id {@link Long}
     * @return {@link BookingAllResponseDto}
     */
    @PutMapping("/{id}/cancel")
    public BookingAllResponseDto cancel(
            @Principal final Long userId,
            @PathVariable @Positive final Long id) {
        return bookingInternalService.cancel(userId, id);
    }

    /**
     * Complete booking.
     *
     * @param userId {@link Long}
     * @param id {@link Long}
     * @return {@link BookingAllResponseDto}
     */
    @PutMapping("/{id}/complete")
    public BookingAllResponseDto complete(
            @Principal final Long userId,
            @PathVariable @Positive final Long id) {
        return bookingInternalService.complete(userId, id);
    }
}
