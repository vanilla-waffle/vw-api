package com.waffle.services.composite;

import com.waffle.data.models.rest.request.booking.BookingCreateDto;
import com.waffle.data.models.rest.request.booking.BookingUpdateDto;
import com.waffle.data.models.rest.response.booking.BookingAllResponseDto;
import com.waffle.services.common.BasicCompositeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Booking internal service.
 */
public interface BookingInternalService extends
        BasicCompositeService<
                BookingCreateDto,
                BookingUpdateDto,
                BookingAllResponseDto,
                BookingAllResponseDto> {

    /**
     * Find all.
     *
     * @param query  {@link String}
     * @param page   {@link PageRequest}
     * @param userId {@link Long}
     * @return {@link List<BookingAllResponseDto>}
     */
    Page<BookingAllResponseDto> findAllByUser(String query, PageRequest page, Long userId);

    /**
     * Find all.
     *
     * @param query  {@link String}
     * @param page   {@link PageRequest}
     * @param vehicleId {@link Long}
     * @return {@link List<BookingAllResponseDto>}
     */
    Page<BookingAllResponseDto> findAllByVehicle(String query, PageRequest page, Long vehicleId);

    /**
     * Cancel booking.
     *
     * @param id {@link Long}
     * @return {@link BookingAllResponseDto}
     */
    BookingAllResponseDto cancel(Long id);

    /**
     * Complete booking.
     *
     * @param id {@link Long}
     * @return {@link BookingAllResponseDto}
     */
    BookingAllResponseDto complete(Long id);
}
