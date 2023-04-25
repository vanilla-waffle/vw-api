package com.waffle.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.constants.types.user.DriverLicenseCategory;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Driver license entity.
 */
@Entity
@Table(name = "vw_driver_licenses")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DriverLicense extends BaseEntity {

    @Column(nullable = false)
    private String licenseNumber;

    @Column(nullable = false, length = TextSize.S)
    private String firstName;
    @Column(nullable = false, length = TextSize.S)
    private String lastName;

    private LocalDate birthDate;
    private LocalDate issueDate;
    private LocalDate expirationDate;

    @OneToOne(mappedBy = "profile.driverLicense")
    @JsonBackReference(value = "user-driverLicense")
    private User user;

    @ElementCollection(targetClass = DriverLicenseCategory.class)
    @CollectionTable(name = "vw_driver_license_categories", joinColumns = @JoinColumn(name = "driver_license_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "category_name")
    private Collection<DriverLicenseCategory> categories;
}
