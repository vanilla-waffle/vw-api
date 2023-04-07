package com.waffle.configurations;

import org.mapstruct.*;

/**
 * Config for Mapstruct entity mappers.
 */
@org.mapstruct.MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface MapperConfiguration {
}
