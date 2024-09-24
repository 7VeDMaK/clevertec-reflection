package org.example.utils.current.jsonToJava;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JsonParserTest {
    @ParameterizedTest
    @MethodSource("provideJsonFromFile")
    void shouldParseObject(String json, Object expected) throws Exception {
//        JsonParser.parse()
    }

    private static Stream<Arguments> provideJsonFromFile() {
//        JsonReader.readJsonFromFile()
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }
}