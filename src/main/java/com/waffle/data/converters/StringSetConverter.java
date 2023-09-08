package com.waffle.data.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Collections;
import java.util.Set;

/**
 * String-Set converter.
 */
@Converter
public class StringSetConverter implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(final Set<String> attributes) {
        return attributes == null
                ? ""
                : String.join(",", attributes);
    }

    @Override
    public Set<String> convertToEntityAttribute(final String attributes) {
        if (attributes == null || attributes.isEmpty()) {
            return Collections.emptySet();
        }

        return Set.of(attributes.split(","));
    }
}
