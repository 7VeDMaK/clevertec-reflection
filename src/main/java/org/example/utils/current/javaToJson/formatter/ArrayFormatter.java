package org.example.utils.current.javaToJson.formatter;

import java.lang.reflect.Array;

public class ArrayFormatter implements ValueFormatter {

    private final IndentFormatter indentFormatter = new IndentFormatter();

    @Override
    public StringBuilder format(Object value, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        int length = Array.getLength(value);

        sb.append("[\n");
        for (int i = 0; i < length; i++) {
            Object arrayElement = Array.get(value, i);
            sb.append(indentFormatter.formatIndent(indentLevel + 2));

            if (arrayElement != null && !isPrimitiveOrWrapper(arrayElement.getClass())) {
                sb.append(ValueFormatterFactory.getFormatter(arrayElement).format(arrayElement, indentLevel + 1));
            } else {
                sb.append(ValueFormatterFactory.getFormatter(arrayElement).format(arrayElement, indentLevel + 1));
            }

            if (i < length - 1) {
                sb.append(",\n");
            } else {
                sb.append("\n");
            }
        }
        sb.append(indentFormatter.formatIndent(indentLevel + 1)).append("]");
        return sb;
    }

    private boolean isPrimitiveOrWrapper(Class<?> clazz) {
        return clazz.isPrimitive() ||
                clazz.equals(String.class) ||
                clazz.equals(Boolean.class) ||
                Number.class.isAssignableFrom(clazz) ||
                Character.class.isAssignableFrom(clazz);
    }
}
