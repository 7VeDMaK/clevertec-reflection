package org.example;

import org.example.entity.Example;
import org.example.entity.NestedExample;
import org.example.utils.current.DataProvider;
import org.example.utils.current.JsonWriter;



public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        //Given
        Example example1 = new Example();

        Example example2 = DataProvider.createExample(false);

        NestedExample example3 = DataProvider.createNestedExample(false);

        //Reflection

        //Handler
        String filename = example2.getClass().getSimpleName();
        JsonWriter.write(example2, "src/main/resources/temp/%s.json".formatted(filename));

        String filename2 = example3.getClass().getSimpleName();
        JsonWriter.write(example3, "src/main/resources/temp/%s.json".formatted(filename2));
    }
}

