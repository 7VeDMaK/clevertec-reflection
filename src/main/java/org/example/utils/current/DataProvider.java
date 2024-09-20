package org.example.utils.current;

import org.example.entity.Example;
import org.example.entity.NestedExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {
    public static Example createExample(boolean isEmpty) {
        if (isEmpty) return new Example();
        HashMap<String, Integer> aMapStringInteger = new HashMap<>();
        aMapStringInteger.put("a", 1);
        List<String> aListStringInteger = new ArrayList<>();
        aListStringInteger.add("asdhsfadf");
        aListStringInteger.add("asdf");
        aListStringInteger.add("asdf");
        aListStringInteger.add("");
        List<Map<String, Integer>> aListMapStringInteger = new ArrayList<>();
        aListMapStringInteger.add(aMapStringInteger);
        aListMapStringInteger.add(new HashMap<>());
        return new Example(0, 0, '0', "", 123,
                aMapStringInteger, aListStringInteger, aListMapStringInteger);
    }

    public static NestedExample createNestedExample(boolean isEmpty) {
        if (isEmpty) return new NestedExample();
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] doubleArray = new double[]{1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9, 9};
        char[] charArray = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        String[] stringArray = new String[]{"aa", "bb", "cc", "dd", "ee", "f", "g", "h"};
        Integer[] integerArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Example[] exampleArray = new Example[]{createExample(false)};
        return new NestedExample(intArray, doubleArray, charArray,
                stringArray, integerArray, exampleArray);
    }
}
