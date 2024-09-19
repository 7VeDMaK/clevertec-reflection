package org.example;

import org.example.utils.FieldPrinter;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        //Given
        Example example1 = new Example();

        HashMap<String, Integer> aMapStringInteger = new HashMap<>();
        aMapStringInteger.put("a", 1);
        Example example2 = new Example(1,2.2,'a',"Str",123, aMapStringInteger);

        //Reflection
        FieldPrinter.print(example2);

        //Handler
    }
}

