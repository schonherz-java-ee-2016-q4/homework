package hu.nemethmarcell.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Map<String, List<String>> multiMap = new HashMap<>();

    public static void main(String[] args) {
        String key, word = "";
        System.out.println("Type the key:");

        while (sc.hasNext()) {
            key = sc.next();
            System.out.println("Type the word:");
            word = sc.next();
            addToMap(key, word);
        }
        System.out.println(multiMap.values());
    }

    private static void addToMap(String key, String word) {
        List<String> list = multiMap.get(key);
        if (list == null) {
            multiMap.put(key, list = new ArrayList<String>());
        }
        list.add(word);
    }

}
