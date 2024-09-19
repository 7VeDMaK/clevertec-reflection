package org.example;

import java.util.Map;

public class Example {
    int aInt;
    double aDouble;
    char aChar;
    String aString;
    Integer aInteger;
    Map<String, Integer> aMapStringInteger;


    public Example(int aInt, double aDouble, char aChar, String aString, Integer aInteger, Map<String, Integer> aMapStringInteger) {
        this.aInt = aInt;
        this.aDouble = aDouble;
        this.aChar = aChar;
        this.aString = aString;
        this.aInteger = aInteger;
        this.aMapStringInteger = aMapStringInteger;
    }

    public Example() {

    }
}
