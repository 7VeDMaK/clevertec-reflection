package org.example.utils.current.javaToJson.formatter;

import java.util.Map;

public class MapFormatter implements ValueFormatter {

    private IndentFormatter indentFormatter = new IndentFormatter();

    @Override
    public StringBuilder format(Object value, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        Map<?, ?> map = (Map<?, ?>) value;
        if (map.isEmpty()) {
            sb.append("{}");
            return sb;
        }

        sb.append("{\n");
        int size = map.size();
        int count = 0;

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            sb.append(indentFormatter.formatIndent(indentLevel + 2)).append("\"").append(entry.getKey()).append("\": ");
            sb.append(ValueFormatterFactory.getFormatter(entry.getValue()).format(entry.getValue(), indentLevel + 1));

            if (count < size - 1) {
                sb.append(",\n");
            }
            count++;
        }

        sb.append("\n").append(indentFormatter.formatIndent(indentLevel + 1)).append("}");
        return sb;
    }
}
