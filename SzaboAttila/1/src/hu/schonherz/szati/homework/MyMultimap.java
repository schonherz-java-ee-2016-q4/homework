package hu.schonherz.szati.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMultimap implements Map {

	HashMap map;

	MyMultimap() {
		map = new HashMap<Object, ArrayList<Object>>();
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		for (Object key : map.keySet()) {
			ArrayList list = (ArrayList) map.get(key);
			for (Object item : list) {
				if (value.equals(item))
					return true;
			}
		}

		return false;
	}

	@Override
	public Object get(Object key) {
		return map.get(key);
	}

	@Override
	public Object put(Object key, Object value) {
		ArrayList list = null;
		if (map.containsKey(key)) {
			list = (ArrayList) map.get(key);
			list.add(value);
		} else {
			list = new ArrayList<>();
			list.add(value);
			map.put(key, list);
		}
		return list;
	}

	@Override
	public Object remove(Object key) {
		Object out = null;

		if (map.containsKey(key)) {
			out = map.get(key);
			map.remove(key);
		}

		return out;
	}

	@Override
	public void putAll(Map m) {
		return;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Set keySet() {
		return map.keySet();
	}

	@Override
	public Collection values() {
		ArrayList out = new ArrayList<Object>();

		for (Object key : map.keySet()) {
			ArrayList list = (ArrayList) map.get(key);
			for (Object item : list) {
				out.add(item);
			}
		}

		return out;
	}

	@Override
	public Set entrySet() {
		return map.entrySet();
	}

}
