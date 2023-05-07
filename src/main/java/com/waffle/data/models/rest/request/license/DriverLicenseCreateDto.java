package com.waffle.data.models.rest.request.license;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.data.models.rest.common.DriverLicenseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

/**
 * Driver license create dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DriverLicenseCreateDto extends DriverLicenseDto {

    @JsonIgnore
    private Long userId;

    @Override
    @NotNull
    public String getLicenseNumber() {
        return super.getLicenseNumber();
    }

    @Override
    @NotNull
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    @NotNull
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    @NotNull
    @Past
    public LocalDate getBirthDate() {
        return super.getBirthDate();
    }

    @Override
    @NotNull
    @Past
    public LocalDate getIssueDate() {
        return super.getIssueDate();
    }

    @Override
    @NotNull
    @Future
    public LocalDate getExpirationDate() {
        return super.getExpirationDate();
    }
}
