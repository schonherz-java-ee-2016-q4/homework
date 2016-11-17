package mymulti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class MyMultiImp<K, V> implements MultiMap<K, V> {

	Map<K, ArrayList<V>> multimap;

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
		for (ArrayList<V> val : multimap.values()) {
			if (val.contains(value)) {
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
		ArrayList<V> list;
		if (!multimap.containsKey(key)) {
			list = new ArrayList<V>();
			multimap.put(key, list);
			list.add(value);
			return value;
		}

		list = multimap.get(key);
		list.add(value);
		return value;

	}

	@Override
	public Collection<V> remove(Object key) {
		return multimap.remove(key);

	}

	@Override
	public Object remove(Object key, Object value) {
		if (!multimap.isEmpty() && multimap.containsKey(key) && multimap.containsValue(value)) {
			return multimap.get(key).remove(multimap.get(key).indexOf(value));
		} else {
			return null;
		}
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
		MyMultiImp<?, ?> other = (MyMultiImp<?, ?>) obj;
		if (multimap == null) {
			if (other.multimap != null)
				return false;
		} else if (!multimap.equals(other.multimap))
			return false;
		return true;
	}

}
