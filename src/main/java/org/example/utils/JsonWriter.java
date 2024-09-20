package org.example.utils;

import org.example.JsonFormat;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    public static void write(Object obj, String fileName){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            JsonFormat jsonFormat = new JsonFormat(obj);
            myWriter.write(jsonFormat.json.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
