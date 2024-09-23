package org.example;

import org.example.entity.Customer;
import org.example.entity.Example;
import org.example.entity.NestedExample;
import org.example.utils.current.DataProvider;
import org.example.utils.current.JsonWriter;



public class Main {
    public static void main(String[] args) {

        //Given
        Example example1 = DataProvider.createExample();

        NestedExample example2 = DataProvider.createNestedExample();

        Customer example3 = DataProvider.createCustomer();

        //Reflection

        //Handler
        String filename1 = example1.getClass().getSimpleName();
//        JsonWriter.write(example1, "src/main/resources/temp/%s.json".formatted(filename1));

        String filename2 = example2.getClass().getSimpleName();
//        JsonWriter.write(example2, "src/main/resources/temp/%s.json".formatted(filename2));

        String filename3 = example3.getClass().getSimpleName();
        JsonWriter.write(example3, "src/main/resources/temp/%s.json".formatted(filename3));
    }
}

