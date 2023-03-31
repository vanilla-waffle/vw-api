package com.waffle.data.dto.common;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Vehicle passport dto.
 */
@Data
public class VehiclePassportDto {

    private Long id;
    private LocalDateTime createdAt;

    private String passportNumber;
    private String modelName;
    private String categoryName;
    private LocalDate receivedAt;
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
