package com.waffle.data.models.rest.response.user.license;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.waffle.data.models.rest.common.DriverLicenseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Driver license response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({ "id", "createdAt", "updatedAt" })
public class DriverLicenseResponseDto extends DriverLicenseDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private boolean approved;

    @Override
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate getBirthDate() {
        return super.getBirthDate();
    }

    @Override
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate getIssueDate() {
        return super.getIssueDate();
    }

    @Override
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate getExpirationDate() {
        return super.getExpirationDate();
    }
}
