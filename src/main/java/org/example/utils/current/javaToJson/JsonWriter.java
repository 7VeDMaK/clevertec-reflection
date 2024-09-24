package org.example.utils.current.javaToJson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    public static void write(Object obj, String fileName){
        try {
            FileWriter writer = new FileWriter(fileName);
            JsonFormat jsonFormat = new JsonFormat(obj);
            writer.write(jsonFormat.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
