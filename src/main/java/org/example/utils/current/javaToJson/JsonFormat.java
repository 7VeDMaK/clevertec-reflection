package org.example.utils.current.javaToJson;

public class JsonFormat {
    private StringBuilder json;


    public JsonFormat(StringBuilder json) {
        this.json = json;
    }

    public JsonFormat(Object obj) {
        json = new JsonBuilder().build(obj);
    }

    public StringBuilder getJson() {
        return json;
    }

    @Override
    public String toString() {
        return json.toString();
    }
}
