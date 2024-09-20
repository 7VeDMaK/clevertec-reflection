package org.example.utils.current;

import org.example.utils.current.formatter.IndentFormatter;
import org.example.utils.current.formatter.ValueFormatterFactory;

import java.lang.reflect.Field;

public class JsonBuilder {

    private IndentFormatter indentFormatter = new IndentFormatter();

    public StringBuilder build(Object obj) {
        return build(obj, 0);
    }

    private StringBuilder build(Object obj, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        Class<?> objectClass = obj.getClass();
        Field[] declaredFields = objectClass.getDeclaredFields();

        sb.append(indentFormatter.formatIndent(indentLevel)).append("{\n");

        try {
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                String name = field.getName();
                field.setAccessible(true);
                Object value = field.get(obj);

                sb.append(indentFormatter.formatIndent(indentLevel + 1)).append("\"").append(name).append("\": ");
                sb.append(ValueFormatterFactory.getFormatter(value).format(value, indentLevel));

                if (i < declaredFields.length - 1) {
                    sb.append(",\n");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        sb.append("\n").append(indentFormatter.formatIndent(indentLevel)).append("}");
        return sb;
    }
}
