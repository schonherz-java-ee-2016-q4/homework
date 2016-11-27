package homework1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MyMultimap<K, V> implements Multimap<K, V> {
	private Map<K, ArrayList<V>> multimap = new HashMap<>();

	public MyMultimap() {

	}

	@Override
	public void clear() {
		multimap.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return (multimap.containsKey(key));
	}

	@Override
	public boolean containsValue(Object value) {
		for (ArrayList<V> val : multimap.values()) {
			if (val.contains(value))
				return true;
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
		if (!multimap.containsKey(key)) {
			ArrayList<V> list = new ArrayList<V>();
			list.add((V) value);
			multimap.put(key, list);
		} else {
			multimap.get(key).add(value);
		}
		return null;
	}

	@Override
	public Collection<V> remove(Object key) {
		multimap.remove(key);
		return null;
	}

	@Override
	public Object remove(Object key, Object value) {
		if (multimap.get(key).contains(value)) {
			multimap.get(key).remove(multimap.get(key).indexOf(value));
		}
		return null;
	}

	@Override
	public int size() {
		return multimap.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((multimap == null) ? 0 : multimap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyMultimap other = (MyMultimap) obj;
		if (multimap == null) {
			if (other.multimap != null)
				return false;
		} else if (!multimap.equals(other.multimap))
			return false;
		return true;
	}

	public void printout() {
		for (Map.Entry<K, ArrayList<V>> entry : multimap.entrySet()) {
			System.out.println("Key: [" + entry.getKey() + "]" + " Value(s): " + entry.getValue());
		}

	}

}
