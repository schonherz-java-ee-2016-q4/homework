package com.gmail.kovtamas1991.tests;

import java.util.Collection;
import java.util.LinkedList;

import com.gmail.kovtamas1991.collections.ListBasedMultiMap;
import com.gmail.kovtamas1991.collections.MultiMap;

public class MainForTests {

    private static MultiMap<String, Integer> testMap;

    private static void reset() {
        testMap = new ListBasedMultiMap<>();
    }

    public static void main(String[] args) {
        reset();
        putAndGetTest();
        reset();
        cleanAndSizeCheckTest();
    }



    private static void putAndGetTest() {
        Collection<Integer> firstExpected = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            firstExpected.add(i);
            testMap.put("first", i);
        }
        Collection<Integer> secondExpected = new LinkedList<>();
        for (int i = 22; i < 100; i++) {
            secondExpected.add(i);
            testMap.put("second", i);
        }

        if (testMap.get(null).size() != 0) {
            throw new RuntimeException("get(null) didn't return empty collection!");
        }

        if (testMap.get(new Integer(3)).size() != 0) {
            throw new RuntimeException("get(wrong key type) didn't return empty collection!");
        }

        Collection<Integer> firstResult = testMap.get("first");
        Collection<Integer> secondResult = testMap.get("second");

        if (!firstExpected.equals(firstResult)
                || !secondExpected.equals(secondResult)) {
            throw new RuntimeException("Returned result is invalid!");
        }
    }

    private static void cleanAndSizeCheckTest() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                testMap.put(Integer.toString(i), j);
            }
        }
        if (testMap.size() != 6) {
            throw new RuntimeException("Size mismatch!");
        }
        if (testMap.isEmpty()) {
            throw new RuntimeException("Map claims that it's empty while it's not!");
        }

        testMap.clear();
        if (testMap.size() != 0) {
            throw new RuntimeException("Size mismatch after clear was called!");
        }
        if (!testMap.isEmpty()) {
            throw new RuntimeException("Map claims that it's not empty while it is!");
        }
    }

}
