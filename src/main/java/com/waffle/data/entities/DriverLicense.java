package com.waffle.data.entities;

import com.waffle.data.constants.types.common.TextSize;
import com.waffle.data.converters.StringSetConverter;
import com.waffle.data.entities.root.DocumentEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Driver license entity.
 */
@Entity
@Table(name = "vw_driver_licenses")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DriverLicense extends DocumentEntity {

    @Column(unique = true, nullable = false)
    private String licenseNumber;

    @Column(nullable = false, length = TextSize.S)
    private String firstName;
    @Column(nullable = false, length = TextSize.S)
    private String lastName;

    private LocalDate birthDate;
    private LocalDate issueDate;
    private LocalDate expirationDate;

    @OneToOne(mappedBy = "profile.driverLicense")
    private User user;

    @Convert(converter = StringSetConverter.class)
    private Set<String> categories;
}
