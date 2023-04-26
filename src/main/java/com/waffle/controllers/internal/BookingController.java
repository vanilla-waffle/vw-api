package com.waffle.controllers.internal;

import com.waffle.data.constants.annotations.spring.Api;
import com.waffle.data.constants.annotations.spring.Principal;
import com.waffle.data.models.rest.request.booking.BookingCreateDto;
import com.waffle.data.models.rest.request.booking.BookingUpdateDto;
import com.waffle.data.models.rest.response.booking.BookingAllResponseDto;
import com.waffle.services.composite.BookingInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@Api("/in/booking")
@RequiredArgsConstructor
public class BookingController {
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
    @GetMapping
    public Page<BookingAllResponseDto> findAll(
            @Principal final Long userId,
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "12") final int size,
            @RequestParam(defaultValue = "id ASC") final String sort) {
         return bookingInternalService.findAllByUser(sort, PageRequest.of(page, size), userId);
    }

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
    @PostMapping("/{vehicleId}")
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
    @PutMapping
    public BookingAllResponseDto update(
            @Principal final Long userId,
            @RequestBody @Valid final BookingUpdateDto payload) {
        return bookingInternalService.update(payload);
    }

    /**
     * Delete one.
     *
     * @param bookingId {@link Long}
     */
    @DeleteMapping("/{bookingId}")
    public void delete(@PathVariable final Long bookingId) {
        bookingInternalService.delete(bookingId);
    }
}
