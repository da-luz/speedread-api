package com.speedread.api.database.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration, Long> {

    @Override
    public Long convertToDatabaseColumn(Duration attribute) {
        if (attribute == null) {
            return null;
        }

        return attribute.toSeconds();
    }

    @Override
    public Duration convertToEntityAttribute(Long duration) {
        if (duration == null) {
            return null;
        }

        return Duration.of(duration, ChronoUnit.SECONDS);
    }
}
