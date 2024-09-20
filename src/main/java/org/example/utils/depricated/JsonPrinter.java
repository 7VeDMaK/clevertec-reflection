package org.example.utils.depricated;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class JsonPrinter {

    public void print(Object obj) {
        print(obj, 0);
    }

    private void print(Object obj, int indentLevel) {
        Class<?> objectClass = obj.getClass();
        Field[] declaredFields = objectClass.getDeclaredFields();

        System.out.println(getIndent(indentLevel) + "{");
        try {
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                String name = field.getName();
                field.setAccessible(true);
                Object value = field.get(obj);

                System.out.print(getIndent(indentLevel + 1) + "\"" + name + "\": ");

                if (value instanceof String || value instanceof Character) {
                    System.out.print("\"" + value + "\"");
                } else if (value instanceof Map) {
                    printMap((Map<?, ?>) value, indentLevel + 1);
                } else if (value instanceof List) {
                    printList((List<?>) value, indentLevel + 1);
                } else if (value != null && value.getClass().isPrimitive() || value instanceof Number || value instanceof Boolean) {
                    System.out.print(value);
                } else {
                    print(value, indentLevel + 1);
                }

                if (i < declaredFields.length - 1) {
                    System.out.println(",");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("\n" + getIndent(indentLevel) + "}");
    }

    private void printValue(Object value, int indentLevel, int size, int i) {
        if (value instanceof Map) {
            printMap((Map<?, ?>) value, indentLevel + 1);
        } else if (value instanceof List) {
            printList((List<?>) value, indentLevel + 1);
        } else if (value instanceof Number || value instanceof Boolean) {
            System.out.print(value);  
        } else if (value == null) {
            System.out.print("null");  
        } else {
            System.out.print("\"" + value + "\"");  
        }

        if (i < size - 1) {
            System.out.println(",");
        }
    }

    private void printMap(Map<?, ?> map, int indentLevel) {
        if (map.isEmpty()) {
            System.out.print("{}");  
            return;
        }
        System.out.println("{");
        int size = map.size();
        int count = 0;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.print(getIndent(indentLevel + 1) + "\"" + entry.getKey() + "\": ");

            Object value = entry.getValue();
            printValue(value, indentLevel, size, count);
            count++;
        }
        System.out.print("\n" + getIndent(indentLevel) + "}");
    }

    private void printList(List<?> list, int indentLevel) {
        if (list.isEmpty()) {
            System.out.print("[]");  
            return;
        }
        System.out.println("[");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object value = list.get(i);
            System.out.print(getIndent(indentLevel + 1));
            printValue(value, indentLevel, size, i);
        }
        System.out.print("\n" + getIndent(indentLevel) + "]");
    }

    private String getIndent(int level) {
        return "  ".repeat(level);
    }
}
