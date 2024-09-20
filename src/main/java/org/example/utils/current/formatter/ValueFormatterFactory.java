package org.example.utils.current.formatter;

import java.util.List;
import java.util.Map;

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
        } else if (value instanceof Map) {
            return new MapFormatter();
        } else if (value instanceof List) {
            return new ListFormatter();
        } else {
            return new DefaultFormatter ();
        }
    }
}
