package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NestedExample {
    int[] intArray;
    double[] doubleArray;
    char[] charArray;
    String[] stringArray;
    Integer[] integerArray;
    Example[] exampleArray;
    Example example;
}
