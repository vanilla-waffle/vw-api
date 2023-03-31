package com.waffle.data.entities.embedded.vehicle;

import com.waffle.data.constants.types.vehicle.VehicleManufacturer;
import com.waffle.data.constants.types.vehicle.VehicleModelType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Vehicle model.
 */
@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleModel {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleManufacturer manuf;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleModelType name;
}
