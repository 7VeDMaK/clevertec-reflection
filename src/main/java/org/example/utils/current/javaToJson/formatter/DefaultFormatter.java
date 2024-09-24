    package org.example.utils.current.javaToJson.formatter;

    public class DefaultFormatter implements ValueFormatter {

        @Override
        public StringBuilder format(Object value, int indentLevel) {
            if (value == null) {
                return new StringBuilder("null");
            }
            return new StringBuilder().append("\"").append(value).append("\"");
        }
    }