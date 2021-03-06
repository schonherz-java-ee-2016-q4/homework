package com.gmail.kovtamas1991.tests;

import java.util.Arrays;
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
        reset();
        containMethodsTest();
        reset();
        removeKeyAndCollectionTest();
        reset();
        removeOneValueTest();
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

        System.out.println("putAndGetTest was successful!");
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

        System.out.println("cleanAndSizeCheck was successful!");
    }

    private static void containMethodsTest() {
        for (int i = 0; i < 15; i++) {
            testMap.put("first", i);
        }
        for (int i = 100; i < 125; i++) {
            testMap.put("second", i);
        }

        Integer[] containedIntegers = new Integer[] {0, 2, 14, 13, 100, 120, 124};
        Integer[] notContainedIntegers = new Integer[] {-1, 15, null, 1000, 125};

        for (Integer i : containedIntegers) {
            if (!testMap.containsValue(i)) {
                throw new RuntimeException("Map should claim to contain " + i + " but it doesn't!");
            }
        }
        for (Integer i : notContainedIntegers) {
            if (testMap.containsValue(i)) {
                throw new RuntimeException("Map should not claim to contain" + i + " but it does!");
            }
        }

        if (testMap.containsKey(null) || testMap.containsKey("no key")) {
            throw new RuntimeException("Map claims to contain a key the was never put into it!");
        }
        if (!testMap.containsKey("first") || !testMap.containsKey("second")) {
            throw new RuntimeException("Map claims that it doesn't contain a key which was put into it before!");
        }

        System.out.println("containMethodsTest was successful!");
    }

    private static void removeKeyAndCollectionTest() {
        testMap.put("first", 100);
        testMap.put("first", 120);
        testMap.put("first", 909);
        testMap.put("second", 0);
        testMap.put("second", -50);
        testMap.put("second", -4567);

        testMap.remove(null);
        testMap.remove("no key");
        if (testMap.size() != 2) {
            throw new RuntimeException("The remove(key) method with unexisting keys affected the map!");
        }

        Collection<Integer> firstValues = testMap.remove("first");
        if (testMap.size() != 1 || testMap.containsKey("first")) {
            throw new RuntimeException("Failed attempt to remove an existing key from the map!");
        }
        if (firstValues.size() != 3) {
            throw new RuntimeException("The size of the retrived collection is invalid!");
        }

        if (!firstValues.containsAll(Arrays.asList(100, 120, 909))) {
            throw new RuntimeException("The retrived collection has invalid content!");
        }

        testMap.remove("second");
        if (!testMap.isEmpty()) {
            throw new RuntimeException("Failed attempt to remove the remaining key with it's collection pair from the map!");
        }

        System.out.println("removeKeyAndCollectionTest was successful!");
    }

    private static void removeOneValueTest() {
        testMap.put("first", 100);
        testMap.put("first", 120);
        testMap.put("first", 909);

        Integer[] expectedValues = new Integer[] {100, 120, 909};
        for (int i = 0; i < expectedValues.length; i++) {
            if (!testMap.remove("first", expectedValues[i]).equals(expectedValues[i])) {
                throw new RuntimeException("Returned value doesn't match the expected value!");
            }
        }

        if (!testMap.isEmpty()) {
            throw new RuntimeException("Map claims not to be empty!");
        }

        System.out.println("removeOneValueTest was successful!");
    }

}
