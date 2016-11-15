package hu.schonherz.java.aron9609;

import hu.schonherz.java.aron9609.multimap.MyMultiMap;

public class Main {
	public static void main(String[] args) {

		MyMultiMap<Integer, String> testMultiMap = new MyMultiMap<>();

		testMultiMap.put(1, "test1");
		testMultiMap.put(1, "test1.2");
		testMultiMap.put(2, "test2");
		testMultiMap.put(2, "test2.2");
		testMultiMap.put(2, "test2.3");
		testMultiMap.put(3, "test3");

		System.out.println("Result of remove key 1: " + testMultiMap.remove(1));

		System.out.println("TestMap contains key 2: " + testMultiMap.containsKey(2));

		System.out.println("TestMap contains value test2.2: " + testMultiMap.containsValue("test2.2"));

		System.out.println("Result of getting values of key 2: " + testMultiMap.get(2));

		testMultiMap.remove(2, "test2.2");

		System.out.println("Result of getting values of key 2 after remove a value : " + testMultiMap.get(2));

		System.out.println("The size of the TestMap: " + testMultiMap.size());

		System.out.println("Is TestMap empty? " + testMultiMap.isEmpty());

		testMultiMap.clear();

		System.out.println("Is TestMap empty after the clear method call? " + testMultiMap.isEmpty());

	}
}
