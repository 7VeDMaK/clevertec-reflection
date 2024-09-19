package org.example.utils;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldPrinter {

    public static void print(Object object) throws IllegalAccessException {
        Class<?> objectClass = object.getClass();

        System.out.println("objectClass = " + objectClass);

        Field[] declaredFields = objectClass.getDeclaredFields();

        System.out.println("declaredFields = " + Arrays.toString(declaredFields));

        for (Field field : declaredFields) {
            String name = field.getName();
            AnnotatedType annotatedType = field.getAnnotatedType();
            field.setAccessible(true);
            Object o = field.get(object);

            System.out.println("name = " + name);
            System.out.println("annotatedType = " + annotatedType);
            System.out.println("object before = " + o);
            System.out.println();
        }
    }
}
