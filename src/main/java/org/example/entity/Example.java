package org.example.entity;

import java.util.List;
import java.util.Map;

public class Example {
    int aInt;
    double aDouble;
    char aChar;
    String aString;
    Integer aInteger;
    Map<String, Integer> aMapStringInteger;
    List<String> aListString;
    List<Map<String, Integer>> aListMapInteger;


    public Example(int aInt, double aDouble, char aChar, String aString, Integer aInteger,
                   Map<String, Integer> aMapStringInteger, List<String> aListString,
                   List<Map<String, Integer>> aListMapInteger) {
        this.aInt = aInt;
        this.aDouble = aDouble;
        this.aChar = aChar;
        this.aString = aString;
        this.aInteger = aInteger;
        this.aMapStringInteger = aMapStringInteger;
        this.aListString = aListString;
        this.aListMapInteger = aListMapInteger;
    }

    public Example() {

    }
}
