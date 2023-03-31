package com.waffle.data.mappers;

import com.waffle.configurations.WaffleMapperConfig;
import com.waffle.data.dto.common.LocationDto;
import com.waffle.data.dto.response.vehicle.VehicleAllDto;
import com.waffle.data.dto.response.vehicle.VehicleSlimDto;
import com.waffle.data.entities.Location;
import com.waffle.data.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mappers class for mapping {@link Vehicle} entity.
 */
@Mapper(componentModel = "spring", config = WaffleMapperConfig.class)
public interface VehicleMapper {

    /**
     * Map from {@link Vehicle} to {@link VehicleAllDto}.
     *
     * @param source {@link Vehicle}
     * @return {@link VehicleAllDto}
     */
    @Mapping(target = "location", source = "location")
    VehicleAllDto convert(Vehicle source);

    /**
     * Map list of {@link Vehicle} to {@link VehicleAllDto}.
     *
     * @param source list of {@link Vehicle}
     * @return list of {@link VehicleAllDto}
     */
    List<VehicleAllDto> convert(List<Vehicle> source);

    /**
     * Map from {@link Vehicle} to {@link VehicleSlimDto}.
     *
     * @param source {@link Vehicle}
     * @return {@link VehicleSlimDto}
     */
    VehicleSlimDto convertSlim(Vehicle source);

    /**
     * Map list of {@link Vehicle} to {@link VehicleSlimDto}.
     *
     * @param source list of {@link Vehicle}
     * @return list of {@link VehicleSlimDto}
     */
    List<VehicleSlimDto> convertSlim(List<Vehicle> source);

    /**
     * Map from {@link Location} to {@link LocationDto}.
     *
     * @param source {@link Location}
     * @return {@link LocationDto}
     */
    LocationDto map(Location source);
}
