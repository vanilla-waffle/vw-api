package com.waffle.data.dto.response.user.root.profile;

import com.waffle.data.dto.common.*;
import com.waffle.data.dto.common.base.ProfileDto;
import com.waffle.data.dto.response.user.BookingResponseDto;
import com.waffle.data.dto.response.user.PaymentMethodResponseDto;
import com.waffle.data.dto.response.vehicle.root.VehicleSlimResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Profile all dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProfileAllResponseDto extends ProfileDto {

    private List<PaymentMethodResponseDto> paymentMethods;
    private List<VehicleSlimResponseDto> vehicles;
    private List<BookingResponseDto> bookings;
    private List<ReviewDto> reviews;
}
