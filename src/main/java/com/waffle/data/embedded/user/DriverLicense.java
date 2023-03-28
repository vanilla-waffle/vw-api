package com.waffle.data.embedded.user;

import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.constants.types.user.DriverLicenseCategory;
import com.waffle.data.entity.User;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Driver license entity.
 */
@Entity
@Table(name = "driver_licenses")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String licenseNumber;

    @Column(nullable = false, length = TextSize.S)
    private String firstName;
    @Column(nullable = false, length = TextSize.S)
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @OneToOne(mappedBy = "driverLicense")
    @Column(nullable = false)
    private User user;

    @ElementCollection(targetClass = DriverLicenseCategory.class)
    @CollectionTable(name = "driver_license_categories", joinColumns = @JoinColumn(name = "driver_license_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "category_name")
    private Collection<DriverLicenseCategory> categories;
}
