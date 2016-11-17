package hu.schonherz.java.aron9609;

import java.util.ArrayList;
import java.util.List;

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

		// testMultiMap.clear();

		// System.out.println("Is TestMap empty after the clear method call? " +
		// testMultiMap.isEmpty());

		// Testing the MultiMapNode class

		MyMultiMap.MultiMapNode<Integer, String> firstNode = new MyMultiMap.MultiMapNode<>(1, "test1.3");
		MyMultiMap.MultiMapNode<Integer, String> secondNode = new MyMultiMap.MultiMapNode<>(2, "test2.4");

		List<String> nodeValues = new ArrayList<>();

		nodeValues.add("tst4");
		nodeValues.add("tst4.1");
		nodeValues.add("tst4.2");
		nodeValues.add("tst4.3");
		nodeValues.add("tst4.4");

		MyMultiMap.MultiMapNode<Integer, String> thirdNode = new MyMultiMap.MultiMapNode<>(4, nodeValues);

		testMultiMap.put(firstNode);
		testMultiMap.put(secondNode);
		testMultiMap.put(thirdNode);

		System.out.println("Result of getting values of key 4 " + testMultiMap.get(4));
	}
}
