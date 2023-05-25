package com.waffle.data.constants.types.vehicle;

import lombok.Getter;

/**
 * An enumeration of popular car models in Central Asia.
 */
public enum VehicleModelType {

    FORD_FIESTA("Ford Fiesta"),
    FORD_FOCUS("Ford Focus"),
    FORD_MUSTANG("Ford Mustang"),
    BMW_3_SERIES("BMW 3 Series"),
    BMW_5_SERIES("BMW 5 Series"),
    BMW_X5("BMW X5"),
    TOYOTA_COROLLA("Toyota Corolla"),
    TOYOTA_CAMRY("Toyota Camry"),
    TOYOTA_RAV4("Toyota RAV4"),
    MERCEDES_BENZ_C_CLASS("Mercedes-Benz C-Class"),
    MERCEDES_BENZ_E_CLASS("Mercedes-Benz E-Class"),
    MERCEDES_BENZ_S_CLASS("Mercedes-Benz S-Class"),
    HONDA_CIVIC("Honda Civic"),
    HONDA_ACCORD("Honda Accord"),
    HONDA_CR_V("Honda CR-V"),
    VOLKSWAGEN_GOLF("Volkswagen Golf"),
    VOLKSWAGEN_JETTA("Volkswagen Jetta"),
    VOLKSWAGEN_PASSAT("Volkswagen Passat"),
    NISSAN_ALTIMA("Nissan Altima"),
    NISSAN_MAXIMA("Nissan Maxima"),
    NISSAN_ROGUE("Nissan Rogue"),
    KIA_OPTIMA("Kia Optima"),
    KIA_SORENTO("Kia Sorento"),
    KIA_SOUL("Kia Soul"),
    HYUNDAI_ELANTA("Hyundai Elantra"),
    HYUNDAI_SONATA("Hyundai Sonata"),
    HYUNDAI_TUCSON("Hyundai Tucson"),
    MAZDA_3("Mazda 3"),
    MAZDA_6("Mazda 6"),
    MAZDA_CX5("Mazda CX-5"),
    CHEVROLET_CRUZE("Chevrolet Cruze"),
    CHEVROLET_CAMARO("Chevrolet Camaro");

    @Getter
    private final String name;

    VehicleModelType(final String name) {
        this.name = name;
    }
}
