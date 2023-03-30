package com.waffle.data.mappers;

import com.waffle.configurations.WaffleMapperConfig;
import com.waffle.data.dto.request.VehicleCreateDto;
import com.waffle.data.dto.request.PostUpdateDto;
import com.waffle.data.dto.response.vehicle.VehicleAllDto;
import com.waffle.data.dto.response.vehicle.VehicleSlimDto;
import com.waffle.data.entity.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mappers class for mapping {@link Vehicle} entity.
 */
@Mapper(componentModel = "spring", config = WaffleMapperConfig.class)
public interface PostMapper {

    /**
     * Map from {@link VehicleCreateDto} to {@link Vehicle}.
     *
     * @param source post create dto
     * @return post entity
     */
    Vehicle fromCreateDtoToPost(VehicleCreateDto source);

    /**
     * Map from {@link PostUpdateDto} to {@link Vehicle}.
     *
     * @param source post update dto
     * @return post entity
     */
    Vehicle fromUpdateDtoToPost(PostUpdateDto source);

    /**
     * Map from {@link Vehicle} to {@link VehicleAllDto}.
     *
     * @param source post
     * @return all response dto
     */
    VehicleAllDto fromPostToAllDto(Vehicle source);

    /**
     * Map lists from {@link Vehicle} to {@link VehicleAllDto}.
     *
     * @param source posts list
     * @return all response dto list
     */
    default List<VehicleAllDto> fromPostToAllDto(final List<Vehicle> source) {
        return source.stream()
                .map(this::fromPostToAllDto)
                .collect(Collectors.toList());
    }

    /**
     * Map from {@link Vehicle} to {@link VehicleSlimDto}.
     *
     * @param source post
     * @return slim response dto
     */
    VehicleSlimDto fromPostToSlimDto(Vehicle source);

    /**
     * Map lists from {@link Vehicle} to {@link VehicleSlimDto}.
     *
     * @param source posts list
     * @return slim response dto list
     */
    default List<VehicleSlimDto> fromPostToSlimDto(final List<Vehicle> source) {
        return source.stream()
                .map(this::fromPostToSlimDto)
                .collect(Collectors.toList());
    }
}
