package org.example.utils.depricated;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldPrinter implements Printer {

    @Override
    public void print(Object obj) {
        Class<?> objectClass = obj.getClass();

        System.out.println("objectClass = " + objectClass);

        Field[] declaredFields = objectClass.getDeclaredFields();

        System.out.println("declaredFields = " + Arrays.toString(declaredFields));

        try {
            for (Field field : declaredFields) {
                String name = field.getName();
                AnnotatedType annotatedType = field.getAnnotatedType();
                field.setAccessible(true);
                Object o = field.get(obj);

                System.out.println("name = " + name);
                System.out.println("annotatedType = " + annotatedType);
                System.out.println("object before = " + o);
                System.out.println();
            }
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
