package com.waffle.data.utils;

import com.waffle.data.constants.types.common.City;
import com.waffle.data.constants.types.user.Status;
import com.waffle.data.constants.types.vehicle.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Enum utils.
 */
public class EnumUtils {

    /**
     * Converts provided string to existing enum.
     *
     * @param str string
     * @return enum
     */
    public static Enum<?> toEnum(final String str) {
        if (str == null) {
            return null;
        }

        for (Enum<?> enumValue : getAllEnumValues()) {
            if (enumValue.name().equalsIgnoreCase(str)) {
                return enumValue;
            }
        }

        return null;
    }

    private static Enum<?>[] getAllEnumValues() {
        List<Enum<?>> allValues = new ArrayList<>();
        allValues.addAll(Arrays.asList(City.values()));
        allValues.addAll(Arrays.asList(Drive.values()));
        allValues.addAll(Arrays.asList(Feature.values()));
        allValues.addAll(Arrays.asList(Transmission.values()));
        allValues.addAll(Arrays.asList(Status.values()));
        allValues.addAll(Arrays.asList(Body.values()));
        allValues.addAll(Arrays.asList(Payment.values()));
        return allValues.toArray(new Enum<?>[0]);
    }
}
