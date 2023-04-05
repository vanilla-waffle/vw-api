package com.waffle.data.mappers;

import com.waffle.configurations.MapperConfiguration;
import com.waffle.data.dto.common.LocationDto;
import com.waffle.data.dto.request.vehicle.VehicleCreateDto;
import com.waffle.data.dto.request.vehicle.VehicleUpdateDto;
import com.waffle.data.dto.response.vehicle.root.VehicleAllResponseDto;
import com.waffle.data.dto.response.vehicle.root.VehicleSlimResponseDto;
import com.waffle.data.entities.Location;
import com.waffle.data.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Mappers class for mapping {@link Vehicle} entity.
 */
@Mapper(componentModel = "spring", config = MapperConfiguration.class)
public interface VehicleMapper {

    /**
     * Merge two {@link Vehicle} into one instance. Ignores null-values from source.
     *
     * @param source {@link Vehicle}
     * @param target {@link Vehicle}
     * @return merged {@link Vehicle}
     */
    @Mapping(source = "paymentPlan.price", target = "paymentPlan.price")
    @Mapping(source = "spec.color", target = "spec.color")
    Vehicle update(Vehicle source, @MappingTarget Vehicle target);

    /**
     * Map from {@link VehicleCreateDto} to {@link Vehicle}.
     *
     * @param source {@link VehicleCreateDto}
     * @return {@link Vehicle}
     */
    Vehicle convert(VehicleCreateDto source);

    /**
     * Map from {@link VehicleUpdateDto} to {@link Vehicle}.
     *
     * @param source {@link VehicleUpdateDto}
     * @return {@link Vehicle}
     */
    Vehicle convert(VehicleUpdateDto source);

    /**
     * Map from {@link Vehicle} to {@link VehicleAllResponseDto}.
     *
     * @param source {@link Vehicle}
     * @return {@link VehicleAllResponseDto}
     */
    @Mapping(target = "location", source = "location")
    VehicleAllResponseDto convertAll(Vehicle source);

    /**
     * Map list of {@link Vehicle} to {@link VehicleAllResponseDto}.
     *
     * @param source list of {@link Vehicle}
     * @return list of {@link VehicleAllResponseDto}
     */
    List<VehicleAllResponseDto> convertAll(List<Vehicle> source);

    /**
     * Map from {@link Vehicle} to {@link VehicleSlimResponseDto}.
     *
     * @param source {@link Vehicle}
     * @return {@link VehicleSlimResponseDto}
     */
    VehicleSlimResponseDto convertSlim(Vehicle source);

    /**
     * Map list of {@link Vehicle} to {@link VehicleSlimResponseDto}.
     *
     * @param source list of {@link Vehicle}
     * @return list of {@link VehicleSlimResponseDto}
     */
    List<VehicleSlimResponseDto> convertSlim(List<Vehicle> source);

    /**
     * Map from {@link Location} to {@link LocationDto}.
     *
     * @param source {@link Location}
     * @return {@link LocationDto}
     */
    LocationDto map(Location source);
}
