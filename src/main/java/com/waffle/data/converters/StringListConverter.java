package com.waffle.data.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Collections;
import java.util.List;

/**
 * String-List converter.
 */
@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(final List<String> attributes) {
        return attributes == null
                ? ""
                : String.join(",", attributes);
    }

    @Override
    public List<String> convertToEntityAttribute(final String attributes) {
        if (attributes == null || attributes.isEmpty()) {
            return Collections.emptyList();
        }

        return List.of(attributes.split(","));
    }
}
