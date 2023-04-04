package com.waffle.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Vehicle passport entity.
 */
@Entity
@Table(name = "vw_vehicle_passport")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehiclePassport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
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
    private String deregistrationNote;

    private String serialNumber;

    @OneToOne(mappedBy = "passport")
    @JsonBackReference(value = "vehicle-passport")
    private Vehicle vehicle;
}
