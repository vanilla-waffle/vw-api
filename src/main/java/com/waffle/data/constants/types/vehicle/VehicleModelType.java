package com.waffle.data.constants.types.vehicle;

import lombok.Getter;

/**
 * An enumeration of popular car models in Central Asia.
 */
public enum VehicleModelType {
    /**
     * Ford Fiesta.
     */
    FORD_FIESTA("Ford Fiesta"),
    /**
     * Ford Focus.
     */
    FORD_FOCUS("Ford Focus"),
    /**
     * Ford Mustang.
     */
    FORD_MUSTANG("Ford Mustang"),
    /**
     * BMW 3 Series.
     */
    BMW_3_SERIES("BMW 3 Series"),
    /**
     * BMW 5 Series.
     */
    BMW_5_SERIES("BMW 5 Series"),
    /**
     * BMW X5.
     */
    BMW_X5("BMW X5"),
    /**
     * Toyota Corolla.
     */
    TOYOTA_COROLLA("Toyota Corolla"),
    /**
     * Toyota Camry.
     */
    TOYOTA_CAMRY("Toyota Camry"),
    /**
     * Toyota RAV4.
     */
    TOYOTA_RAV4("Toyota RAV4"),
    /**
     * Mercedes-Benz C-Class.
     */
    MERCEDES_BENZ_C_CLASS("Mercedes-Benz C-Class"),
    /**
     * Mercedes-Benz E-Class.
     */
    MERCEDES_BENZ_E_CLASS("Mercedes-Benz E-Class"),
    /**
     * Mercedes-Benz S-Class.
     */
    MERCEDES_BENZ_S_CLASS("Mercedes-Benz S-Class"),
    /**
     * Honda Civic.
     */
    HONDA_CIVIC("Honda Civic"),
    /**
     * Honda Accord.
     */
    HONDA_ACCORD("Honda Accord"),
    /**
     * Honda CR-V.
     */
    HONDA_CR_V("Honda CR-V"),
    /**
     * Volkswagen Golf.
     */
    VOLKSWAGEN_GOLF("Volkswagen Golf"),
    /**
     * Volkswagen Jetta.
     */
    VOLKSWAGEN_JETTA("Volkswagen Jetta"),
    /**
     * Volkswagen Passat.
     */
    VOLKSWAGEN_PASSAT("Volkswagen Passat"),
    /**
     * Nissan Altima.
     */
    NISSAN_ALTIMA("Nissan Altima"),
    /**
     * Nissan Maxima.
     */
    NISSAN_MAXIMA("Nissan Maxima"),
    /**
     * Nissan Rogue.
     */
    NISSAN_ROGUE("Nissan Rogue"),
    /**
     * Kia Optima.
     */
    KIA_OPTIMA("Kia Optima"),
    /**
     * Kia Sorento.
     */
    KIA_SORENTO("Kia Sorento"),
    /**
     * Kia Soul.
     */
    KIA_SOUL("Kia Soul"),
    /**
     * Hyundai Elantra.
     */
    HYUNDAI_ELANTA("Hyundai Elantra"),
    /**
     * Hyundai Sonata.
     */
    HYUNDAI_SONATA("Hyundai Sonata"),
    /**
     * Hyundai Tucson.
     */
    HYUNDAI_TUCSON("Hyundai Tucson"),
    /**
     * Mazda 3.
     */
    MAZDA_3("Mazda 3"),
    /**
     * Mazda 6.
     */
    MAZDA_6("Mazda 6"),
    /**
     * Mazda CX-5.
     */
    MAZDA_CX5("Mazda CX-5"),
    /**
     * Chevrolet Cruze.
     */
    CHEVROLET_CRUZE("Chevrolet Cruze"),
    /**
     * Chevrolet Camaro.
     */
    CHEVROLET_CAMARO("Chevrolet Camaro");

    @Getter
    private final String name;

    VehicleModelType(final String name) {
        this.name = name;
    }
}
