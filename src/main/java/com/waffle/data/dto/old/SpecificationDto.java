package com.waffle.data.dto.old;

import com.waffle.data.constants.types.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * DTO class of embedded class Specification for Post.
 */
public enum SpecificationDto {
    ;

    private interface ColorEnum {
        @NotBlank @NotNull Color getColor();
    }

    private interface BodyEnum {
        @NotBlank @NotNull Body getBody();
    }

    private interface DriveEnum {
        @NotBlank @NotNull Drive getDrive();
    }

    private interface TransmissionEnum {
        @NotBlank @NotNull Transmission getTransmission();
    }

    private interface FuelEnum {
        @NotBlank @NotNull Fuel getFuel();
    }

    private interface EngineVolume {
        @NotBlank @NotNull @Positive Integer getEngineVolume();
    }

    private interface Doors {
        @NotBlank @NotNull @Positive Integer getDoors();
    }

    private interface Seats {
        @NotBlank @NotNull @Positive Integer getSeats();
    }

    /**
     * Request objects of SpecificationDto.
     */
    public enum Request {
        ;

        /**
         * Request objects of SpecificationDto.
         */
        @Data
        public static class Create implements ColorEnum, BodyEnum, DriveEnum, TransmissionEnum, FuelEnum, EngineVolume, Doors, Seats {
            private Color color;
            private Body body;
            private Drive drive;
            private Transmission transmission;
            private Fuel fuel;
            private Integer engineVolume;
            private Integer doors;
            private Integer seats;
        }
    }

    /**
     * Response objects of SpecificationDto.
     */
    public enum Response {
        ;

        /**
         * Slim response object of SpecificationDto.
         */
        @Data
        public static class All implements ColorEnum, BodyEnum, DriveEnum, TransmissionEnum, FuelEnum, EngineVolume, Doors, Seats {
            private Color color;
            private Body body;
            private Drive drive;
            private Transmission transmission;
            private Fuel fuel;
            private Integer engineVolume;
            private Integer doors;
            private Integer seats;
        }
    }
}
