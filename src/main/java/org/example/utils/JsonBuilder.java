package org.example.utils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class JsonBuilder {

    public StringBuilder build(Object obj) {
        return build(obj, 0);
    }

    private StringBuilder build(Object obj, int indentLevel) {
        StringBuilder sb = new StringBuilder();

        Class<?> objectClass = obj.getClass();
        Field[] declaredFields = objectClass.getDeclaredFields();

        sb.append(getIndent(indentLevel)).append("{\n");

        try {
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                String name = field.getName();
                field.setAccessible(true);
                Object value = field.get(obj);

                sb.append(getIndent(indentLevel + 1)).append("\"").append(name).append("\": ");

                if (value instanceof String || value instanceof Character) {
                    sb.append("\"").append(value).append("\"");
                } else if (value instanceof Map) {
                    sb.append(buildMap((Map<?, ?>) value, indentLevel + 1));
                } else if (value instanceof List) {
                    sb.append(buildList((List<?>) value, indentLevel + 1));
                } else if (value != null && value.getClass().isPrimitive() || value instanceof Number || value instanceof Boolean) {
                    sb.append(value);
                } else {
                    sb.append(build(value, indentLevel + 1));
                }

                if (i < declaredFields.length - 1) {
                    sb.append(",\n");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        sb.append("\n").append(getIndent(indentLevel)).append("}\n");
        return sb;
    }

    private StringBuilder buildValue(Object value, int indentLevel, int size, int i) {
        StringBuilder sb = new StringBuilder();
        if (value instanceof Map) {
            sb.append(buildMap((Map<?, ?>) value, indentLevel + 1));
        } else if (value instanceof List) {
            sb.append(buildList((List<?>) value, indentLevel + 1));
        } else if (value instanceof Number || value instanceof Boolean) {
            sb.append(value);
        } else if (value == null) {
            sb.append("null");
        } else {
            sb.append("\"").append(value).append("\"");
        }

        if (i < size - 1) {
            sb.append(",\n");
        }
        return sb;
    }

    private StringBuilder buildMap(Map<?, ?> map, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        if (map.isEmpty()) {
            sb.append("{}");
            return sb;
        }
        sb.append("{\n");
        int size = map.size();
        int count = 0;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            sb.append(getIndent(indentLevel + 1)).append("\"").append(entry.getKey()).append("\": ");

            Object value = entry.getValue();
            sb.append(buildValue(value, indentLevel, size, count));
            count++;
        }
        sb.append("\n").append(getIndent(indentLevel)).append("}");
        return sb;
    }

    private StringBuilder buildList(List<?> list, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        if (list.isEmpty()) {
            sb.append("[]");
            return sb;
        }
        sb.append("[\n");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object value = list.get(i);
            sb.append(getIndent(indentLevel + 1));
            sb.append(buildValue(value, indentLevel, size, i));
        }
        sb.append("\n").append(getIndent(indentLevel)).append("]");
        return sb;
    }

    private String getIndent(int level) {
        return "  ".repeat(level);
    }
}
