package com.waffle.data.models.rest.response.user.root.profile;

import com.waffle.data.models.rest.common.DriverLicenseDto;
import com.waffle.data.models.rest.common.ReviewDto;
import com.waffle.data.models.rest.common.ProfileDto;
import com.waffle.data.models.rest.response.booking.BookingAllResponseDto;
import com.waffle.data.models.rest.response.user.payment.PaymentMethodResponseDto;
import com.waffle.data.models.rest.response.vehicle.root.VehicleSlimResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Profile all dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProfileAllResponseDto extends ProfileDto {

    private DriverLicenseDto driverLicense;

    private List<PaymentMethodResponseDto> paymentMethods;
    private List<VehicleSlimResponseDto> vehicles;
    private List<BookingAllResponseDto> bookings;
    private List<ReviewDto> reviews;
}
