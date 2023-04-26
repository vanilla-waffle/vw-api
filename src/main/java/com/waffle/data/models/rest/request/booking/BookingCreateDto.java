package com.waffle.data.models.rest.request.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.data.constants.types.booking.BookingStatus;
import com.waffle.data.models.rest.common.BookingDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;


/**
 * Booking create dto.
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class BookingCreateDto extends BookingDto {

    @JsonIgnore
    private Long userId;

    @NotNull
    @Positive
    private Long vehicleId;

    @Override
    @NotNull
    @FutureOrPresent
    public LocalDateTime getStartsAt() {
        return super.getStartsAt();
    }

    @Override
    @NotNull
    @FutureOrPresent
    public LocalDateTime getCompletesAt() {
        return super.getCompletesAt();
    }

    @Override
    @JsonIgnore
    public Double getTotalPrice() {
        return super.getTotalPrice();
    }

    @Override
    @JsonIgnore
    public BookingStatus getStatus() {
        return super.getStatus();
    }
}
