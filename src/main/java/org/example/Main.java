package org.example;

import org.example.utils.FieldPrinter;
import org.example.utils.JsonPrinter;
import org.example.utils.JsonWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        //Given
        Example example1 = new Example();

        HashMap<String, Integer> aMapStringInteger = new HashMap<>();
        aMapStringInteger.put("a", 1);
        List<String> aListStringInteger = new ArrayList<>();
        aListStringInteger.add("asdhsfadf");
        aListStringInteger.add("asdf");
        aListStringInteger.add("asdf");
        aListStringInteger.add("");
        List<Map<String, Integer>> aListMapStringInteger = new ArrayList<>();
        aListMapStringInteger.add(aMapStringInteger);
        aListMapStringInteger.add(new HashMap<>());
        Example example2 = new Example(0,0,'0',"",123,
                aMapStringInteger, aListStringInteger, aListMapStringInteger);

        //Reflection
        FieldPrinter fieldPrinter = new FieldPrinter();
//        fieldPrinter.print(example2);

        JsonPrinter jsonPrinter = new JsonPrinter();
        jsonPrinter.print(example2);

        //Handler
        String filename = example2.getClass().getSimpleName();
        JsonWriter.write(example2, "%s.json".formatted(filename));
    }
}

