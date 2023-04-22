package com.waffle.data.models.rest.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

/**
 * Vehicle passport dto.
 */
@Data
public class VehiclePassportDto {

    @JsonFormat(pattern = "dd-MM-yyyy")
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
