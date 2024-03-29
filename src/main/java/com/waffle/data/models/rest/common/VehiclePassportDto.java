package com.waffle.data.models.rest.common;

import lombok.Data;

import java.time.LocalDate;

/**
 * Vehicle passport dto.
 */
@Data
public class VehiclePassportDto {

    private boolean approved;

    private LocalDate receivedAt;

    private String passportNumber;
    private String modelName;
    private String categoryName;
    private String vin;
    private Integer releaseYear;
    private Double engineVolume;
    private String color;
    private Integer permittedMass;
    private String ownerName;
    private String registeredPlace;

    private String specialNotes;
    private String deregestrationNote;

    private String serialNumber;
}
