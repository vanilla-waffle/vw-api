package com.waffle.data.dto.response.user.profile;

import com.waffle.data.dto.common.*;
import com.waffle.data.dto.common.base.ProfileDto;
import com.waffle.data.dto.response.vehicle.VehicleSlimDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Profile all dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProfileAllDto extends ProfileDto {

    private List<PaymentMethodDto> paymentMethods;
    private List<VehicleSlimDto> vehicles;
    private List<BookingDto> bookings;
    private List<ReviewDto> reviews;
}
