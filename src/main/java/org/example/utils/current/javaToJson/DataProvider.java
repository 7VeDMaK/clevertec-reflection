package org.example.utils.current.javaToJson;

import org.example.entity.Customer;
import org.example.entity.Example;
import org.example.entity.NestedExample;
import org.example.entity.Order;
import org.example.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DataProvider {
    public static Example createExample() {
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

    public static NestedExample createNestedExample() {
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] doubleArray = new double[]{1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9, 9};
        char[] charArray = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        String[] stringArray = new String[]{"aa", "bb", "cc", "dd", "ee", "f", "g", "h"};
        Integer[] integerArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Example[] exampleArray = new Example[]{createExample()};
        Example example = createExample();
        return new NestedExample(intArray, doubleArray, charArray,
                stringArray, integerArray, exampleArray, example);
    }

    public static Product createProduct() {
        UUID id = UUID.randomUUID();
        String name = "name";
        Double price = 1.2;
        Map<UUID, BigDecimal> priceMap = new HashMap<>();
        priceMap.put(id, BigDecimal.valueOf(price + 100));
        priceMap.put(UUID.randomUUID(), BigDecimal.valueOf(price + 15));

        return new Product(id, name, price, priceMap);
    }

    public static Order createOrder() {
        UUID id = UUID.randomUUID();
        List<Product> products = new ArrayList<>();
        products.add(createProduct());
        products.add(createProduct());
        OffsetDateTime createDate = OffsetDateTime.now(ZoneId.of("Asia/Jakarta"));
        return new Order(id, products, createDate);
    }

    public static Customer createCustomer() {
        UUID id = UUID.randomUUID();
        String firstName = "firstName";
        String lastName = "lastName";
        LocalDate dateBirth = LocalDate.now();
        List<Order> orders = new ArrayList<>();
        orders.add(createOrder());
        orders.add(createOrder());
        return new Customer(id, firstName, lastName, dateBirth, orders);
    }
}
