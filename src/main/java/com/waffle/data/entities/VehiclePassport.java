package com.waffle.data.entities;

import com.waffle.data.entities.root.DocumentEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Vehicle passport entity.
 */
@Entity
@Table(name = "vw_vehicle_passport")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VehiclePassport extends DocumentEntity {

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
    private String deregistrationNote;

    private String serialNumber;

    @OneToOne(mappedBy = "passport", fetch = FetchType.LAZY)
    private Vehicle vehicle;
}
