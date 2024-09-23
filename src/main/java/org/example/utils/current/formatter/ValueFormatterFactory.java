package org.example.utils.current.formatter;

import java.time.OffsetDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ValueFormatterFactory {

    public static ValueFormatter getFormatter(Object value) {
        if (value == null) {
            return new DefaultFormatter();
        } else if (value.getClass().isArray()) {
            return new ArrayFormatter();
        } else if (value instanceof String || value instanceof Character) {
            return new DefaultFormatter();
        } else if (value instanceof Number || value instanceof Boolean) {
            return new PrimitiveFormatter();
        } else if (value instanceof TemporalAccessor) {
            return new TemporalFormatter();
        } else if (value instanceof UUID) {
            return new UUIDFormatter();
        } else if (value instanceof Map) {
            return new MapFormatter();
        } else if (value instanceof List) {
            return new ListFormatter();
        } else if (isCustomObject(value)) {
            return new ObjectFormatter();
        } else {
            return new DefaultFormatter();
        }
    }

    private static boolean isCustomObject(Object value) {
        return !(value instanceof String || value instanceof Character || value instanceof Number ||
                value instanceof Boolean || value.getClass().isPrimitive());
    }
}
