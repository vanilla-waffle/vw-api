package com.waffle.data.dto.request.vehicle;

import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.dto.common.LocationDto;
import com.waffle.data.dto.common.PaymentPlanDto;
import com.waffle.data.dto.common.VehiclePassportDto;
import com.waffle.data.dto.common.SpecificationDto;
import com.waffle.data.constants.types.vehicle.Feature;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

/**
 * Request, dto class to create a Post.
 */
@Data
public class VehicleCreateDto {

    @NotNull
    @Positive
    private Long userId;

    @NotEmpty
    @Length(max = TextSize.M)
    private String title;

    @NotEmpty
    @Length(max = TextSize.XXL)
    private String description;

    @NotEmpty
    private String manuf;
    @NotEmpty
    private String model;

    @NotNull
    @Positive
    private Integer releaseYear;

    @NotNull
    private VehiclePassportDto passport;

    @NotNull
    private PaymentPlanDto paymentPlan;
    @NotNull
    private SpecificationDto spec;
    @NotNull
    private LocationDto location;

    private Set<Feature> features;
}
