package org.example;

import org.example.entity.Customer;
import org.example.entity.Example;
import org.example.entity.NestedExample;
import org.example.utils.current.javaToJson.DataProvider;
import org.example.utils.current.javaToJson.JsonWriter;
import org.example.utils.current.jsonToJava.JsonParser;
import org.example.utils.current.jsonToJava.JsonReader;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        //Part 1. Java -> Json

        //Given
        Example example1 = DataProvider.createExample();

        NestedExample example2 = DataProvider.createNestedExample();

        Customer example3 = DataProvider.createCustomer();

        //Handler
        String filename1 = example1.getClass().getSimpleName();
        JsonWriter.write(example1, "src/main/resources/temp/%s.json".formatted(filename1));

        String filename2 = example2.getClass().getSimpleName();
        JsonWriter.write(example2, "src/main/resources/temp/%s.json".formatted(filename2));

        String filename3 = example3.getClass().getSimpleName();
        JsonWriter.write(example3, "src/main/resources/temp/%s.json".formatted(filename3));


        // Part 2 Json -> Java

        //Given
        try {
            String json1 = JsonReader.readJsonFromFile(("src/main/resources/temp/%s.json").formatted(filename1));
            Example example = JsonParser.parse(json1, Example.class);
            String filename4 = example.getClass().getSimpleName();
            JsonWriter.write(example, "src/main/resources/temp/check/%s.json".formatted(filename4));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

