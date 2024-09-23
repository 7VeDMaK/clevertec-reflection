package org.example.utils.current.formatter;

import java.util.UUID;

public class UUIDFormatter implements ValueFormatter {

    @Override
    public StringBuilder format(Object value, int indentLevel) {
        UUID uuid = (UUID) value;
        return new StringBuilder("\"").append(uuid.toString()).append("\"");
    }
}
