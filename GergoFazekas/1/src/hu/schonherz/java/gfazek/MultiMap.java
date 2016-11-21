package hu.schonherz.java.gfazek;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiMap<K, V> implements IMultiMap<K, V>{

	private Map<K, List<V>> multimap = new HashMap<>();
	
	@Override
	public void clear() {
		multimap.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return multimap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		for (K key : multimap.keySet()) {
			if (multimap.get(key).contains(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Collection<V> get(Object key) {
		return multimap.get(key);
	}

	@Override
	public boolean isEmpty() {
		return multimap.isEmpty();
	}

	@Override
	public V put(K key, V value) {
		if (multimap.containsKey(key) && !multimap.get(key).contains(value)) {
			multimap.get(key).add(value);
		} else if (!multimap.containsKey(key)){
			
			multimap.put(key, new ArrayList<V>());
			multimap.get(key).add(value);
		}
		return value;
		
	}

	@Override
	public Collection<V> remove(Object key) {
		return multimap.remove(key);
	}

	@Override
	public Object remove(Object key, Object value) {
		if (multimap.containsKey(key) && multimap.get(key).contains(value)) {
			multimap.get(key).remove(value);
			return value;
		}
		return null;
	}

	@Override
	public int size() {
		return multimap.size();
	}
	
	@Override
	public String toString() {
		return multimap.toString();
	}
	

//		public static void main(String[] args) {
//		MultiMap<String, Integer> map = new MultiMap<>();
//		System.out.println(map.isEmpty());
//		System.out.println(map.put("key1", 1));
//		System.out.println(map.put("key2", 2));
//		System.out.println(map.put("key3", 3));
//		System.out.println(map.put("key2", 9));
//		System.out.println(map);
//		System.out.println(map.get("key2"));
//		System.out.println(map.remove("key2"	, 2));
//		System.out.println(map);
//		System.out.println(map.containsValue(2));
//		MultiMap<Integer, Integer> map2 = new MultiMap<>();
//		System.out.println(map2);
//		map2.put(5, 9);
//		System.out.println(map2);
//		map2.put(5, 9);
//		System.out.println(map2);
//		map2.put(6, 10);
//		System.out.println(map2);
//		map2.put(6, 11);
//		System.out.println(map2);
//		map2.put(6, 11);
//		System.out.println(map2);
//	}
}