# Custom JSON Parser Library

This project involves translating between Java classes and JSON, with support for some levels of nesting, such as lists and maps. It includes both serialization (class to JSON) and deserialization (JSON to class), handling class processing within classes, as well as basic nesting structures like lists and maps, and classes within classes.

## Features

- **Class to JSON Translation**: Converts Java classes into JSON strings, handling nested structures (lists, maps, etc.).
- **JSON to Class Parsing**: Converts JSON strings back into Java classes, supporting up to two levels of nesting (e.g., map within map).
- **Custom Implementation**: This project doesn't use existing libraries like Jackson, as the goal is to implement this functionality from scratch.

## Progress

- Translation from class to JSON, including some support for nested lists and maps.
- Parsing from JSON to class, handling up to two levels of nesting (e.g., maps within maps).
- Class processing inside other classes (class within class structures).
- **What is missing**:
    - No tests.
    - No controllers.
    - No generalization in the JSON to class part (repeated code).

## Future Improvements

- Adding unit tests.
- Creating controllers for better interaction.
- Generalizing the code for parsing JSON to class to avoid repetition.
- Reviewing Jackson solutions to compare and optimize.

## How to Use
 
Project provides the following functionalities:
- **Parsing**: Read JSON strings and convert them into Java objects.
- **Reading/Writing**: Methods to serialize and deserialize classes into .json format.

You can find usage examples in the `main` method, which demonstrates the current implementation of parsing, reading, and writing Java classes.
