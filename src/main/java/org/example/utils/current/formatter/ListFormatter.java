package org.example.utils.current.formatter;

import java.util.List;

public class ListFormatter implements ValueFormatter {

    private IndentFormatter indentFormatter = new IndentFormatter();

    @Override
    public StringBuilder format(Object value, int indentLevel) {
        StringBuilder sb = new StringBuilder();
        List<?> list = (List<?>) value;
        if (list.isEmpty()) {
            sb.append("[]");
            return sb;
        }

        sb.append("[\n");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object listItem = list.get(i);
            sb.append(indentFormatter.formatIndent(indentLevel + 2));
            sb.append(ValueFormatterFactory.getFormatter(listItem).format(listItem, indentLevel + 1));

            if (i < size - 1) {
                sb.append(",\n");
            }
        }
        sb.append("\n").append(indentFormatter.formatIndent(indentLevel + 1)).append("]");
        return sb;
    }
}
