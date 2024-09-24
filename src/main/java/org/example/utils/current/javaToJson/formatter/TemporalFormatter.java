package org.example.utils.current.javaToJson.formatter;

import java.time.temporal.TemporalAccessor;

public class TemporalFormatter implements ValueFormatter {

    @Override
    public StringBuilder format(Object value, int indentLevel) {
        TemporalAccessor temporal = (TemporalAccessor) value;
        return new StringBuilder("\"").append(temporal.toString()).append("\"");
    }
}
