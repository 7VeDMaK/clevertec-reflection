package org.example.utils.current.formatter;

public class PrimitiveFormatter implements ValueFormatter {

    @Override
    public StringBuilder format(Object value, int indentLevel) {
        return new StringBuilder().append(value);
    }
}
