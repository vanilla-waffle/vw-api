package com.waffle.configurations;

import com.waffle.data.constants.annotations.spring.NonDocumented;
import org.mapstruct.*;

@NonDocumented
@MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface MapperConfiguration {
}
