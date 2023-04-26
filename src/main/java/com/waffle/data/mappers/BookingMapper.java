package com.waffle.data.mappers;

import com.waffle.configurations.MapperConfiguration;
import com.waffle.data.entities.Booking;
import com.waffle.data.models.rest.request.booking.BookingCreateDto;
import com.waffle.data.models.rest.request.booking.BookingUpdateDto;
import com.waffle.data.models.rest.response.booking.BookingAllResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Booking mapper.
 */
@Mapper(componentModel = "spring", config = MapperConfiguration.class)
public interface BookingMapper {

    /**
     * Merge two {@link Booking} into one instance. Ignores null-values source.
     *
     * @param payload {@link Booking}
     * @param actual {@link Booking}
     * @return {@link Booking}
     */
    Booking update(Booking payload, @MappingTarget Booking actual);

    /**
     * Map from {@link BookingCreateDto} to {@link Booking}.
     *
     * @param source {@link BookingCreateDto}
     * @return {@link Booking}
     */
    Booking convert(BookingCreateDto source);

    /**
     * Map from {@link BookingUpdateDto} to {@link Booking}.
     *
     * @param source {@link BookingUpdateDto}
     * @return {@link Booking}
     */
    Booking convert(BookingUpdateDto source);

    /**
     * Map from {@link Booking} to {@link BookingAllResponseDto}.
     *
     * @param source {@link Booking}
     * @return {@link BookingAllResponseDto}
     */
    BookingAllResponseDto convertAll(Booking source);

    /**
     * Map list of {@link Booking} to {@link BookingAllResponseDto}.
     *
     * @param source {@link List<Booking>}
     * @return {@link BookingAllResponseDto}
     */
    List<BookingAllResponseDto> convertAll(List<Booking> source);
}
