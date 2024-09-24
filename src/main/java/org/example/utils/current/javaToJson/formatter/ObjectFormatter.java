package org.example.utils.current.javaToJson.formatter;

import java.lang.reflect.Field;

public class ObjectFormatter implements ValueFormatter {

    private final IndentFormatter indentFormatter = new IndentFormatter();

    @Override
    public StringBuilder format(Object value, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        Class<?> objClass = value.getClass();
        Field[] fields = objClass.getDeclaredFields();

        sb.append("{\n");
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            sb.append(indentFormatter.formatIndent(indentLevel + 2))
                    .append("\"").append(field.getName()).append("\": ");
            try {
                Object fieldValue = field.get(value);
                sb.append(ValueFormatterFactory.getFormatter(fieldValue).format(fieldValue, indentLevel + 1));
            } catch (IllegalAccessException e) {
                sb.append("\"<inaccessible>\"");
            }

            if (i < fields.length - 1) {
                sb.append(",\n");
            } else {
                sb.append("\n");
            }
        }
        sb.append(indentFormatter.formatIndent(indentLevel + 1)).append("}");
        return sb;
    }
}
