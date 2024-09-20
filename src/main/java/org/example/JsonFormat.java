package org.example;

import org.example.utils.JsonBuilder;

public class JsonFormat {
    public StringBuilder json;


    public JsonFormat(StringBuilder json) {
        this.json = json;
    }

    public JsonFormat(Object obj) {
        JsonBuilder jsonBuilder = new JsonBuilder();
        json = jsonBuilder.build(obj);
    }
}
