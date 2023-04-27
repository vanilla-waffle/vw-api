package com.waffle.controllers.internal.booking;

import com.waffle.data.constants.annotations.spring.Api;
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
     * Cancel booking.
     *
     * @param id {@link Long}
     * @return {@link BookingAllResponseDto}
     */
    @PutMapping("/{id}/cancel")
    public BookingAllResponseDto cancel(@PathVariable @Positive final Long id) {
        return bookingInternalService.cancel(id);
    }

    /**
     * Complete booking.
     *
     * @param id {@link Long}
     * @return {@link BookingAllResponseDto}
     */
    @PutMapping("/{id}/complete")
    public BookingAllResponseDto complete(@PathVariable @Positive final Long id) {
        return bookingInternalService.complete(id);
    }
}
