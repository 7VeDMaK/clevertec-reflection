package org.example.utils.current.jsonToJava;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JsonParser {

    public static <T> T parse(String json, Class<T> clazz) throws Exception {
        json = json.trim().replaceAll("[{}]", "");
        String[] keyValuePairs = splitJsonPairs(json);

        T instance = clazz.getDeclaredConstructor().newInstance();

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":", 2);
            String key = keyValue[0].trim().replaceAll("\"", "");
            String value = keyValue[1].trim();
            Field field = clazz.getDeclaredField(key);
            field.setAccessible(true);

            if (field.getType() == UUID.class) {
                field.set(instance, UUID.fromString(value.replaceAll("\"", "")));
            } else if (field.getType() == String.class) {
                field.set(instance, value.replaceAll("\"", ""));
            }
            if (field.getType() == char.class) {
                String charValue = value.replaceAll("\"", "");
                if (charValue.length() == 1) {
                    field.set(instance, charValue.charAt(0));
                }
            } else if (field.getType() == LocalDate.class) {
                field.set(instance, LocalDate.parse(value.replaceAll("\"", "")));
            } else if (field.getType() == int.class || field.getType() == Integer.class) {
                field.set(instance, Integer.parseInt(value));
            } else if (field.getType() == List.class || field.getType() == Map.class) {
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType pt) {
                    if (field.getType() == List.class) {
                        Type listItemType = pt.getActualTypeArguments()[0];
                        List<?> list = parseCollection(value, listItemType);
                        field.set(instance, list);
                    } else {
                        Class<?> keyClass = (Class<?>) pt.getActualTypeArguments()[0];
                        Class<?> valueClass = (Class<?>) pt.getActualTypeArguments()[1];
                        Map<?, ?> map = parseMap(value, keyClass, valueClass);
                        field.set(instance, map);
                    }
                }
            }
        }
        return instance;
    }

    private static String[] splitJsonPairs(String json) {
        List<String> pairs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int braceCount = 0;
        for (char c : json.toCharArray()) {
            if (c == '{' || c == '[') {
                braceCount++;
            } else if (c == '}' || c == ']') {
                braceCount--;
            }
            if (c == ',' && braceCount == 0) {
                pairs.add(sb.toString().trim());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        pairs.add(sb.toString().trim());
        return pairs.toArray(new String[0]);
    }

    private static <T> List<T> parseCollection(String json, Type itemType) throws Exception {
        json = json.trim().replaceAll("[\\[\\]]", "");
        String[] items = splitJsonPairs(json);
        List<T> list = new ArrayList<>();

        for (String item : items) {
            if (itemType == String.class) {
                list.add((T) item.replaceAll("\"", "").trim());
            } else if (itemType == Integer.class || itemType == int.class) {
                list.add((T) Integer.valueOf(item));
            } else if (itemType == Double.class || itemType == double.class) {
                list.add((T) Double.valueOf(item));
            } else if (itemType == Boolean.class || itemType == boolean.class) {
                list.add((T) Boolean.valueOf(item));
            } else if (itemType instanceof ParameterizedType pt) {
                Class<?> rawType = (Class<?>) pt.getRawType();
                if (rawType == Map.class) {
                    if (item.trim().equals("")) {
                        list.add((T) new HashMap<>());
                    } else {
                        Class<?> keyClass = (Class<?>) pt.getActualTypeArguments()[0];
                        Class<?> valueClass = (Class<?>) pt.getActualTypeArguments()[1];
                        Map<?, ?> map = parseMap(item, keyClass, valueClass);
                        list.add((T) map);
                    }
                } else if (rawType == List.class) {
                    List<?> nestedList = parseCollection(item, pt.getActualTypeArguments()[0]);
                    list.add((T) nestedList);
                } else {
                    list.add((T) parse(item, (Class<?>) itemType));
                }
            } else {
                list.add((T) item);
            }
        }
        return list;
    }


    private static <K, V> Map<K, V> parseMap(String json, Class<K> keyClass, Class<V> valueClass) throws Exception {
        json = json.trim().replaceAll("[{}]", "");
        String[] keyValuePairs = splitJsonPairs(json);

        Map<K, V> map = new HashMap<>();
        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":", 2);
            K key = keyClass.cast(keyValue[0].replaceAll("\"", "").trim());
            V value;

            String rawValue = keyValue[1].trim();

            if (valueClass == String.class) {
                value = valueClass.cast(rawValue.replaceAll("\"", ""));
            } else if (valueClass == Integer.class || valueClass == int.class) {
                value = valueClass.cast(Integer.parseInt(rawValue));
            } else if (valueClass == Double.class || valueClass == double.class) {
                value = valueClass.cast(Double.parseDouble(rawValue));
            } else if (valueClass == Boolean.class || valueClass == boolean.class) {
                value = valueClass.cast(Boolean.parseBoolean(rawValue));
            } else {
                value = valueClass.cast(parse(rawValue, valueClass));
            }

            map.put(key, value);
        }
        return map;
    }
}
