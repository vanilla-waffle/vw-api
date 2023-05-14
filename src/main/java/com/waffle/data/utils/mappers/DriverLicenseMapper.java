package com.waffle.data.utils.mappers;

import com.waffle.configurations.MapperConfiguration;
import com.waffle.data.entities.DriverLicense;
import com.waffle.data.models.rest.request.license.DriverLicenseCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = MapperConfiguration.class)
public interface DriverLicenseMapper {

    /**
     * Map from {@link DriverLicenseCreateDto} to {@link DriverLicense}.
     *
     * @param source {@link DriverLicenseCreateDto}.
     * @return {@link DriverLicense}
     */
    DriverLicense convert(DriverLicenseCreateDto source);
}
