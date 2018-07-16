package com.example.demo_array_map;

import org.junit.Test;

import java.util.LinkedHashMap;

public class LinkedMapTest {

    @Test
    public void testAccessOrder() {
        LinkedHashMap<Integer, String> map
                = new LinkedHashMap<>(0, 0.75f, true);
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "b");
        System.out.println("Original: " + map);

        String val = map.get(1);
        System.out.println("After access 1: " + map);

        val = map.get(2);
        System.out.println("After access 2: " + map);

        val = map.get(0);
        System.out.println("After access 0: " + map);

        val = map.get(3);
        System.out.println("After access 3: " + map);
    }
}
