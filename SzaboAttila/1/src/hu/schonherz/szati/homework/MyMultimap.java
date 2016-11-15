package hu.schonherz.szati.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MyMultimap<K, V> implements MultiMap<K, V> {

	private HashMap<K, ArrayList<V>> map;

	public MyMultimap() {
		map = new HashMap<>();
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		for (Object key : map.keySet()) {
			if (map.get(key).contains(value)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public Collection<V> get(Object key) {
		return map.get(key);
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public V put(K key, V value) {
		ArrayList<V> list;

		if (!map.containsKey(key)) {
			list = new ArrayList<V>();
			list.add(value);
			map.put(key, list);

			return null;
		}

		list = map.get(key);
		list.add(value);

		return list.get(list.size() - 2);
	}

	@Override
	public Collection<V> remove(Object key) {
		Collection<V> out = get(key);
		map.remove(key);
		return out;
	}

	@Override
	public Object remove(Object key, Object value) {
		Collection<V> res = map.get(key);

		if (res == null) {
			return null;
		}

		if (res.remove(value)) {
			return value;
		} else {
			return null;
		}
	}

	@Override
	public int size() {
		return map.size();
	}

	// generated with eclipse
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		return result;
	}

	// generated with eclipse
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyMultimap other = (MyMultimap) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		return true;
	}

}
