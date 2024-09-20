package org.example.entity;

public class NestedExample {
    int[] intArray;
    double[] doubleArray;
    char[] charArray;
    String[] stringArray;
    Integer[] integerArray;
    Example[] exampleArray;

    public NestedExample(int[] intArray, double[] doubleArray, char[] charArray,
                         String[] stringArray, Integer[] integerArray, Example[] exampleArray) {
        this.intArray = intArray;
        this.doubleArray = doubleArray;
        this.charArray = charArray;
        this.stringArray = stringArray;
        this.integerArray = integerArray;
        this.exampleArray = exampleArray;
    }

    public NestedExample() {
    }
}
