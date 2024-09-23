package org.example.utils.current.jsonToJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public static String readJsonFromFile(String filePath) throws IOException {
        StringBuilder json = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                json.append(line);
            }
        }
        return json.toString();
    }
}
