package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Example {
    int aInt;
    double aDouble;
    char aChar;
    String aString;
    Integer aInteger;
    Map<String, Integer> aMapStringInteger;
    List<String> aListString;
    List<Map<String, Integer>> aListMapInteger;
}
